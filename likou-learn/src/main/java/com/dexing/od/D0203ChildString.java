package com.dexing.od;

import java.util.Scanner;

/*
 * 判断字符串子序列
 * 给定字符串 target和 source, 判断 target 是否为 source 的子序列。
 * 你可以认为 target 和 source 中仅包含英文小写字母。字符串 source可能会很长（长度 ~= 500,000），而 target 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"abc"是"aebycd"的一个子序列， 而"ayb"不是）。
 * 请找出最后一个子序列的起始位置。
 * 输入描述:
 * 第一行为target，短字符串（长度 <=100）
 * 第二行为source，长字符串（长度 ~= 500,000）
 * 输出描述:
 * 最后一个子序列的起始位置， 即最后一个子序列首字母的下标
 * 示例1
 * 输入
 * abc
 * abcaybec
 * 输出
 * 3
 * 说明
 * 这里有两个abc的子序列满足，取下标较大的，故返回3
 * 备注:
 * 若在source中找不到target，则输出-1
 */
public class D0203ChildString {
    //解题方法：双指针法, 题目要求返回下标最大的字串，可以用倒序遍历字符串，返回第一个结果
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String t = scanner.nextLine();
        String s = scanner.nextLine();
        int ti = t.length() - 1;
        int si = s.length() - 1;
        //如果指针所指位置字符相等，两个指针都左移一位，否则只将source指针左移一位
        while (ti > 0 && si > 0) {
            if (t.charAt(ti) == s.charAt(si)) {
                if (ti == 0) {
                    System.out.println("倒序搜索第一个子串完成");
                    System.out.println(si);
                    return;
                }
                ti--;
            }
            si--;
        }
        System.out.println(-1);
    }
}
