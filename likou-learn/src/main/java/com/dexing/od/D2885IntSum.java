package com.dexing.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/***
 * 一个整数可以由连续的自然数之和来表示。给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式。
 * 输入描述:
 * 一个目标整数T (1 <=T<= 1000)
 * 输出描述:
 * 该整数的所有表达式和表达式的个数。如果有多种表达式，输出要求为：
 * 1.自然数个数最少的表达式优先输出
 * 2.每个表达式中按自然数递增的顺序输出，具体的格式参见样例。在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
 * 示例1
 * 输入
 * 9
 * 输出
 * 9=9
 * 9=4+5
 * 9=2+3+4
 * Result:3
 * 说明
 * 整数 9 有三种表示方法，第1个表达式只有1个自然数，最先输出，第2个表达式有2个自然数，第2次序输出，第3个表达式有3个自然数，最后输出。每个表达式中的自然数都是按递增次序输出的。
 * 数字与符号之间无空格
 * 示例2
 * 输入
 * 10
 * 输出
 * 10=10
 * 10=1+2+3+4
 * Result:2
 */
public class D2885IntSum {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        int input = 10;
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int total = 0;
        for (int i = 1; i <= input; i++) {
            int tem  = i;
            ArrayList<Integer> list = new ArrayList<>();
            while (total <= input) {
                list.add(tem);
                total += tem;
                tem++;
                if (total == input) {
                    lists.add(list);
                    break;
                }
            }
            total =0;
        }
        for (int i = lists.size()-1; i >= 0; i--) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(input+"=");
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                buffer.append(list.get(j)+"+");
            }
            System.out.println(buffer.substring(0,buffer.length()-1));
        }
        System.out.println("Result:"+lists.size());
    }
}
