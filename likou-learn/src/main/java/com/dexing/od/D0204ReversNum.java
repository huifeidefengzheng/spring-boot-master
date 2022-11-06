package com.dexing.od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 输入一个英文文章片段，翻转指定区间的单词顺序，标点符号和普通字母一样处理。例如输入字符串"I am a developer. “，区间[0,3]，则输出"developer. a am I"
 * String reverseWords(String s, int start, int end)
 * 输入描述:
 * 使用换行隔开三个参数，第一个参数为英文文章内容即英文字符串，第二个参数为翻转起始单词下标(下标从0开始)，第三个参数为结束单词下标。
 * 输出描述:
 * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出
 * 示例1：
 * 输入
 * I am a developer.
 * 1
 * 2
 * 输出
 * I a am developer.
 * 示例2：
 * 输入
 * hello world!
 * 0
 * 1
 * 输出
 * world! hello
 * 说明
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例3：
 * 输入
 * I am a developer.
 * 0
 * 3
 * 输出
 * developer. a am I
 * 说明
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例4：
 * 输入
 * Hello!
 * 0
 * 3
 * 输出
 * EMPTY
 * 说明
 * 指定翻转区间只有一个单词或无有效单词，则统一输出"EMPTY"
 */
public class D0204ReversNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        String[] split = s.split("\\s+");
        if ((end - start + 1) > split.length || end == start || end < 0) {
            System.out.println("EMPTY");
            return;
        }
        List<String> strings = Arrays.asList(split);
        List<String> strings1 = strings.subList(start, end + 1);
        Stack<String> strings2 = new Stack<>();
        for (String str : strings1) {
            strings2.push(str);
        }
        for (int i = start; i <= end + 1; i++) {
            strings.set(start, strings2.pop());
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.size(); i++) {
            if (i == strings.size() - 1) {
                stringBuffer.append(strings.get(i));
            } else {
                stringBuffer.append(strings.get(i)).append(" ");
            }
        }

        System.out.println(stringBuffer);
    }

    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        String[] split = s.split("\\s+");
        if (end > split.length - 1 || start == end || start > split.length - 1 || end < 0) {
            System.out.println("EMPTY");
            return;
        }

        int j = end;

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            if (i >= start && i <= end) {
                stringBuffer.append(split[j--]).append(" ");
            } else {
                stringBuffer.append(split[i]).append(" ");
            }
        }
        System.out.println(stringBuffer);
    }
}
