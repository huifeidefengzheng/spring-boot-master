package com.dexing.od;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入字符串s，输出s中包含所有整数的最小和
 * 说明
 * 字符串s，只包含 a-z A-Z ± ；
 * 合法的整数包括
 * 1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
 * 2）负整数 负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 输入描述:
 * 包含数字的字符串
 * 输出描述:
 * 所有整数的最小和
 * 示例1
 * 输入
 * bb1234aa
 * 输出
 * 10
 * 示例2
 * 输入
 * bb12-34aa
 * 输出
 * -31
 * 说明
 * 1+2+（-34） = 31
 */
public class D2064StringMin {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String input = "bb12-34-1";
        char[] chars = input.toCharArray();
        boolean isFushu = false;
        String tem = "-";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c) ) {
               if (isFushu ) {
                   tem += c;
                   if (i == chars.length -1) {
                       list.add(Integer.parseInt(tem));
                   }
               } else {
                   list.add(Integer.parseInt(c+""));
               }
                continue;
            }
            if (isFushu && tem != "-") {
                list.add(Integer.parseInt(tem));
                tem = "-";
            }
            isFushu = c == '-';
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
