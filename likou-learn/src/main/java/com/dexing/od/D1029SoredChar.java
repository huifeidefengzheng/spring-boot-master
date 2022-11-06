package com.dexing.od;

import java.util.*;

/**
 * 输入一个由 n 个大小写字母组成的字符串，
 * 按照 Ascii 码值从小到大的排序规则，
 * 查找字符串中第 k 个最小ascii 码值的字母（k >= 1），输出该字母所在字符串的位置索引(字符串的第一个字符位置索引为 0）。
 * k 如果大于字符串长度，则输出最大 ascii 值的字母所在字符串的位置索引，
 * 如果有重复的字母，则输出字母的最小位置索引。
 * 输入描述：
 * 第一行输入一个由大小写字母组成的字符串
 * 第二行输入 k，k 必须大于 0，k 可以大于输入字符串的长度
 * 输出描述：
 * 输出字符串中第 k 个最小 ascii 码值的字母所在字符串的位置索引。k 如果大于字符串长度，则输出最大 ascii 值的字母所
 * 在字符串的位置索引，如果第 k 个最小 ascii 码
 * 值的字母存在重复，则输出该字母的最小位置索引。
 * 示例 1：
 * 输入
 * AbCdeFG
 * 3
 * 输出
 * 5
 */
public class D1029SoredChar {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String str = "AbCdeFG" ;
        int k = 3;
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
        }
        Collections.sort(characters);
        int size = characters.size();
        int temp = 0;
        if (k <= size) {
            temp = getMinIndex(k,str,characters);
        } else {
            temp = getMaxIndex(size,str,characters);
        }
        System.out.println(temp);
    }
    private static int getMaxIndex(int size, String str, List<Character> characters) {
        return str.indexOf(characters.get(size-1));
    }
    private static int getMinIndex(int k, String str, List<Character> characters) {
        if (k-2>=0) {
            Character k2 = characters.get(k - 2);
            Character k1 = characters.get(k - 1);
            if (k2 == k1) {
                return str.indexOf(k2) > str.indexOf(k1) ? str.indexOf(k1) : str.indexOf(k2);}}
        return str.indexOf(characters.get(k-1));
    }
}
