package com.dexing.od;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 现有一字符串仅由( , ) , { , } , [ , ]六种括号组成。若字符串满足以下条件之一，则为无效字符串：
 * 1、任一类型的左右括号数量不相等；
 * 2、存在未按正确顺序（先左后右）闭合的括号。
 * <p>
 * 输出括号的最大嵌套深度，若字符串无效则输出0.
 * 0<=字符串长度<=100000
 * <p>
 * 输入描述：
 * 一个只包( , ) , { , } , [ , ]的字符串。
 * <p>
 * 输出描述:
 * 一个整数，最大括号深度
 * <p>
 * 示例1：
 * 输入:[]
 * 输出:1
 */
public class D0410LenthKuoHao {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");
        /*Scanner scanner = new Scanner(System.in);
        String kuohaoStr = scanner.nextLine();*/
        String kuohaoStr = "{}()[]((()){})";
        int len = maxDepth(kuohaoStr);

        System.out.println(len);
    }

    private static int maxDepth(String kuohaoStr) {
        String copyStr = kuohaoStr;
        int length = kuohaoStr.length();

        // 括号是否成对出现，
        if (length % 2 != 0) {
            return 0;
        }
        // 判断括号是否 一一对应
        int len = length / 2;
        while (len > 0) {
            copyStr = copyStr.replace("{}", "").replace("()", "").replace("[]", "");
            len--;
        }
        int depth = 0;
        int zuokuohao = 0;
        int youkuohao = 0;
        // 满足要求一一对应，换成同一种括号计算
        if (copyStr.length() == 0) {
            kuohaoStr = kuohaoStr.replace("{", "(").replace("}", ")").replace("[", "(").replace("]", ")");
            for (int i = 0; i < length; i++) {
                if (kuohaoStr.charAt(i) == '(') {
                    zuokuohao++;
                } else {
                    youkuohao++;
                }
                depth = Math.max(depth, zuokuohao - youkuohao);
            }
            return depth;
        } else {
            return 0;
        }
    }

    private static int maxDepth2(String kuohaoStr) {
        int depth = 0;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < kuohaoStr.length(); i++) {
            char at = kuohaoStr.charAt(i);
            if (at == '(' || at == '{' || at == '[') {
                stack.push(at);
                depth = Math.max(depth, stack.size());
                continue;
            }
            if (at == ')') {
                Character pop = stack.pop();
                if (pop == '(') {
                    continue;
                } else {
                    flag = false;
                    return 0;
                }
            }
            if (at == ']') {
                Character pop = stack.pop();
                if (pop == '[') {
                    continue;
                } else {
                    flag = false;
                    return 0;
                }
            }

            if (at == '}') {
                Character pop = stack.pop();
                if (pop == '{') {
                    continue;
                } else {
                    flag = false;
                    return 0;
                }
            }
        }
        if (flag) {
            if (stack.size() == 0) {
                return depth;
            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }

}
