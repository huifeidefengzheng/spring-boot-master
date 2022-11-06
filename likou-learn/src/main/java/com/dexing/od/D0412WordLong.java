package com.dexing.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * 题目描述
 * 单词接龙的规则是
 * 可用于接龙的单词 首字母必须要与前一个单词的尾字母相同
 * 当存在多个首字母相同的单词时，取长度最长的单词
 * 如果长度也相等，则取字典序最小的单词
 * 已经参与接龙的单词不能重复使用
 * 现给定一组全部由小写字母组成的单词数组
 * 并指定其中一个单词为起始单词
 * 进行单词接龙
 * 请输出最长的单词串
 * 单词串是单词拼接而成的中间没有空格
 *
 * 输入描述
 * 输入第一行为一个非负整数
 * 表示起始单词在数组中的索引k
 * 0<=k<N
 * 输入的第二行为非负整数N
 * 接下来的N行分别表示单词数组中的单词
 *
 * 输出描述
 * 输出一个字符串表示最终拼接的单词串。
 *
 * 示例1
 * 输入
 *
 * 0
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 *
 * 输出
 *
 * worddwordda
 *
 * 说明 先确定起始单词word 在接dword
 * 剩余dd da dc 则取da
 *
 * 示例2
 * 输入
 *
 * 4
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 *
 * 输出
 *
 * dwordda
 *
 * 单词个数1<N<20
 * 单个单词的长度  1~30
 */
public class D0412WordLong {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int startWordIndex = Integer.parseInt(scanner.nextLine());
        int wordsNum = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < wordsNum; i++) {
            list.add(scanner.nextLine());
        }*/
        int startWordIndex = 0;
        int wordsNum = 6;
        List<String> list = new ArrayList<>();
        initData(list);
        ArrayList<String> restList = new ArrayList<>();
        String startWord = list.remove(startWordIndex);
        while (startWord != null) {
            restList.add(startWord);
            startWord = getNextWord(startWord, list);
        }
        System.out.println(String.join("", restList));

    }

    public static void initData(List<String> list) {
        list.add("word");
        list.add("dd");
        list.add("da");
        list.add("dc");
        list.add("dword");
        list.add("d");
    }

    private static String getNextWord(String startWord, List<String> list) {
        if (startWord == null && list.isEmpty()) {
            return null;
        }
        String res = null;
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            String cur = list.get(i);
            // 首字母必须要与前一个单词的尾字母相同
            if (startWord.charAt(startWord.length() - 1) == cur.charAt(0)) {
                if (res == null) {
                    res = cur;
                    index = i;
                    // 当存在多个首字母相同的单词时，取长度最长的单词
                } else if (cur.length() > res.length()) {
                    res = cur;
                    index = i;
                    // 如果长度也相等，则取字典序最小的单词
                } else if (cur.length() == res.length() && cur.compareTo(res) < 0) {
                    res = cur;
                    index = i;
                }
            }
        }
        if (index == -1) {
            return null;
        } else {
            return list.remove(index);
        }
    }
}
