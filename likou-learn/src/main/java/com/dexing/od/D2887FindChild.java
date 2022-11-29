package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个字符串，从字符串2中找出字符串1中的所有字符，去重并按照ASCII值从小到大排序
 * 输入字符串1：长度不超过1024
 * 输入字符串2：长度不超过1000000
 * 字符范围满足ASCII编码要求，按照ASCII的值由小到大排序
 * 输入描述:
 * bach
 * bbaaccedfg
 * 输出描述:
 * abc
 * 示例1
 * 输入
 * fach
 * bbaaccedfg
 * 输出
 * acf
 * 说明
 * 备注:
 * 输入字符串1 为给定字符串bach，输入字符串2 bbaaccedfg
 * 从字符串2中找出字符串1的字符，去除重复的字符，并且按照ASCII值从小到大排序，得到输出的结果为abc。
 * 字符串1中的字符h在字符串2中找不到不输出。
 */
public class D2887FindChild {
    public static void main(String[] args) {
        maopao();
    }

    public static void test() {
        String str1 = "fach";
        String str2 = "bbaaccedfg";
        String res = "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            String s = String.valueOf(ch);
            if (str1.contains(s)) {
                list.remove(s);
                list.add(s);
            }
        }
        list.sort((v1,v2) -> v1.compareTo(v2));
        list.stream().forEach(vo -> System.out.print(vo));
        System.out.println();
    }

    /**
     * 冒泡排序
     */
    public static void maopao(){
        String str2 = "bbaacfcdedfg";
        int length = str2.length();
        char[] chars = str2.toCharArray();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length -1 -i ; j++) {
                if (chars[j] > chars[j+1]) {
                    char aChar = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = aChar;
                }
            }
        }
        System.out.println();
    }
}
