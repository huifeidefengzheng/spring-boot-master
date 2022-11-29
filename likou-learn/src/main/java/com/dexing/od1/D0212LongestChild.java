package com.dexing.od1;

import java.util.Scanner;

/**
 * 给你一个字符串 s，字符串s首尾相连成一个环形 ，请你在环中找出 ‘o’ 字符出现了偶数次最长子字符串的长度。
 * 输入描述:
 * 输入是一串小写字母组成的字符串
 * 输出描述:
 * 输出是一个整数
 * 示例1
 * 输入
 * alolobo
 * 输出
 * 6
 * 说明
 * 最长子字符串之一是 “alolob”，它包含’o’ 2个。
 * 示例2
 * 输入
 * looxdolx
 * 输出
 * 7
 * 说明
 * 最长子字符串是 “oxdolxl”，由于是首尾连接在一起的，所以最后一个 ‘x’ 和开头的 ‘l’是连接在一起的，此字符串包含 2 个’o’ 。
 * 示例3
 * 输入
 * bcbcbc
 * 输出
 * 6
 * 说明
 * 这个示例中，字符串 “bcbcbc” 本身就是最长的，因为 ‘o’ 都出现了 0 次。
 * 备注:
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 */
public class D0212LongestChild {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        int o1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'o') {
                o1++;
            }
        }
        if (o1 % 2 == 0){
            System.out.println(input.length());
        }else {
            System.out.println(input.length() -1);
        }
    }
}
