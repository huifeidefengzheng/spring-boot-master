package com.dexing.od;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 28.【字符串中包含的最长的非严格递增连续数字序列长度】
 * 题目描述：
 *
 * 输入一个字符串仅包含大小写字母和数字
 * 求字符串中包含的最长的非严格递增连续数字序列长度
 * 比如：
 *     12234属于非严格递增数字序列
 * 示例：
 * 输入
 *     abc2234019A334bc
 * 输出
 *     4
 * 说明：
 *     2234为最长的非严格递增连续数字序列，所以长度为4
 *
 *     aaaaaa44ko543j123j7345677781
 *     aaaaa34567778a44ko543j123j71
 *     345678a44ko543j123j7134567778aa
 */
public class D0924StringUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int len =0 ,maxLen= 0;
            Character ch = '0';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= ch && c <= '9') {
                    ch = c;
                    len++;
                    maxLen = Math.max(len,maxLen);
                } else if (c >= '0' && c <= '9') {
                    len = 1;
                    ch = c;
                } else {
                    len = 0;
                    ch = '0';
                }

            }
            System.out.println(maxLen);
        }
    }

    public static void test() {
        String s = "abc2234019A334bc";
        int len = 0;
        Character ch = '0';
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= ch && c <= '9') {
                ch = c;
                characters.add(ch);
            } else if (ch > c) {
                len = Math.max(len, characters.size());
                characters.clear();
                ch = '0';
            }

        }
        System.out.println(len);
    }

    public static void tets2() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int maxLength = 0;
        int length = 0;
        char maxChar = '0';  // 存储上一个数字字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= maxChar && c <= '9') {  // 判断是否是非递减
                length++;
                maxChar = c;
                maxLength = Math.max(length, maxLength);
            } else if (c >= '0' && c <= '9') {  // 是数字，但小于上一个数字
                length = 1;
                maxChar = c;
            } else {  // 如果不是数字
                length = 0;
                maxChar = '0';
            }
        }

        System.out.println(maxLength);
    }

}
