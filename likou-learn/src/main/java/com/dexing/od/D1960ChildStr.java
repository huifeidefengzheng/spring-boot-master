package com.dexing.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 给定字符串 target和 source, 判断 target 是否为 source 的子序列。
 * 你可以认为 target 和 source 中仅包含英文小写字母。字符串 source可能会很长（长度 ~= 500,000），而 target 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"abc"是"aebycd"的一个子序列，而"ayb"不是）。
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
public class D1960ChildStr {
    public static void main(String[] args) {
        test2();
    }
    public static void test2() {
        /**/Scanner sc = new Scanner(System.in);
        String target = "ayb";//[0,100]
        String source = "aebycd";//[0,50w]
        int idx = source.length();
        for (int i = target.length()-1; i >= 0; i--) {
            char ta = target.charAt(i);
            if (source.contains(String.valueOf(ta))) {
                int idxLast = source.lastIndexOf(String.valueOf(ta));
                if (idxLast < idx){
                    idx = idxLast;
                }else {
                    System.out.println(-1);
                    return;
                }
            }else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(idx);
    }
    public static void test() {
        String chStr = "abc";
        String parent = "abcaybec";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < parent.length(); i++) {
            map.put(parent.charAt(i),i);
        }
        int rest = 0;
        for (int i = 0; i < chStr.length(); i++) {
            char c = chStr.charAt(i);
            if (!parent.contains(c+"")) {
                System.out.println(-1);
                break;
            }
            Integer integer = map.get(c);
            if (integer > rest) {
                rest = integer;
            } else {
                System.out.println(-1);
                break;
            }
        }
        System.out.println(map.get(chStr.charAt(0)));
    }
}
