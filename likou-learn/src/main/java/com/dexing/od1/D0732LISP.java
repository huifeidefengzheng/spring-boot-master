package com.dexing.od1;

import java.util.Scanner;
import java.util.Stack;

/**
 * LISP 语言唯一的语法就是括号要配对。
 *  形如 (OP P1 P2 …)，括号内元素由单个空格分割。
 *  其中第一个元素 OP 为操作符，后续元素均为其参数，参数个数取决于操作符类型。
 *  注意：
 *  参数 P1, P2 也有可能是另外一个嵌套的 (OP P1 P2 …) ，
 *  当前 OP 类型为 add / sub / mul / div（全小写），分别代表整数的加减乘除法，
 *  简单起见，所有 OP 参数个数均为 2 。
 *  举例:
 *  输入：(mul 3 -7)
 *  输出：-21
 *  输入：(add 1 2)
 *  输出：3
 *  输入：(sub (mul 2 4) (div 9 3))
 *  输出：5
 *  输入：(div 1 0)
 *  输出：error
 *  题目涉及数字均为整数，可能为负；
 *  不考虑 32 位溢出翻转，计算过程中也不会发生 32 位溢出翻转，
 *  除零错误时，输出 “error”，
 *  除法遇除不尽，向下取整，即 3/2 = 1
 */
public class D0732LISP {
    //标记是否合法表达式
    public static boolean error_flag;

    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        String lisp_str = in.nextLine().replaceAll("\\(", "( ").replaceAll("\\)", " )");
        String[] lisp_params = lisp_str.split(" ");

        Stack<String> patten = new Stack<>();
        Stack<String> opera = new Stack<>();

        int op1, op2;
        String operation;
        error_flag = false;
        int res = 0;
        for (int i = 0; i < lisp_params.length; i++) {
            //分支判定各字符
            switch (lisp_params[i]) {
                case "(":
                    patten.push("(");
                    break;
                case ")":
                    if (patten.isEmpty()) {
                        error_flag = true;
                    }
                    patten.pop();
                    op2 = Integer.parseInt(opera.pop());
                    op1 = Integer.parseInt(opera.pop());
                    operation = opera.pop();
                    res = cal(operation, op1, op2);
                    opera.push(String.valueOf(res));
                    break;
                default:
                    opera.push(lisp_params[i]);
            }
            if(error_flag) {
                break;
            }
        }
        if (error_flag) {
            System.out.println("error");
        } else {
            System.out.println(res);
        }
    }
    public static int cal(String operation, int op1, int op2) {
        int result = 0;
        switch (operation) {
            case "add":
                result = op1 + op2;
                break;
            case "sub":
                result = op1 - op2;
                break;
            case "mul":
                result = op1 * op2;
                break;
            default:
                if (op2 == 0) {
                    error_flag = true;
                } else {
                    result = op1 / op2;
                }
        }
        return result;
    }
}
