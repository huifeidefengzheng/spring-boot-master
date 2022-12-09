package com.dexing.od1;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个长度为4的倍数的字符串，字符串中仅包含WASD四个字母。
 *
 * 将这个字符串中的连续子串用同等长度的仅包含WASD的字符串替换，如果替换后整个字符串中WASD四个字母出现的频数相同，那么我们称替换后的字符串是“完美走位”。
 *
 * 求子串的最小长度。
 *
 * 如果输入字符串已经平衡则输出0。
 *
 * 输入描述
 * 一行字符表示给定的字符串s
 *
 * 数据范围：1<=n<=10^5且n是4的倍数，字符串中仅包含WASD四个字母。
 *
 * 输出描述
 * 一个整数表示答案
 *
 * 用例
 * 输入	WASDAASD
 * 输出	1
 * 说明	将第二个A替换为W，即可得到完美走位
 * 输入	AAAA
 * 输出	3
 * 说明	将其中三个连续的A替换为WSD，即可得到完美走位
 * 题目解析
 * 题目要求，保持W,A,S,D字母个数平衡，即相等，如果不相等，可以从字符串中选取一段连续子串替换，来让字符串平衡。
 * 比如：WWWWAAAASSSS
 *
 * 字符串长度12，W,A,S,D平衡的话，则每个字母个数应该是3个，而现在W,A,S各有4个，也就是说各超了1个。
 *
 * 因此我们应该从字符串中，选取一段包含1个W，1个A，1个S的子串，来替换为S。
 *
 * WWWWAAAASSSS
 *
 * WWWWAAAASSSS
 *
 * WWWWAAAASSSS
 *
 * ........
 *
 * WWWWAAAASSSS
 *
 * 而符合这种要求的子串可能很多，我们需要找出其中最短的，即WAAAAS。
 *
 * 本题其实就是求最小覆盖子串，同LeetCode - 76 最小覆盖子串_伏城之外的博客-CSDN博客
 *
 * 题目解析请看上面链接博客。
 */
public class D0526PerfectStep {
    public static void main(String[] args) {

    }

    public static void test() {
        String input = "";
        char[] chars = input.toCharArray();
        // 此时count记录统计W,A,S,D字母的数量
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer orDefault = map.getOrDefault(c, 0);
            int i1 = orDefault + 1;
            map.put(c,i1);
        }

        // 遍历W A S D防止有没有输入的字母
        for (int i = 0; i < "WASD".length(); i++) {
            char c = "WASD".charAt(i);
            if (map.get(c) == null) {
                map.put(c,0);
            }
        }
        // 特殊情况
        if (map.get('W') == map.get('A') && map.get('W') == map.get('S') && map.get('W') == map.get('D')) {
            System.out.println(0);
            return;
        }

        int left = 0,right =0,length =0;
        // 替换的最小长度
        int res = input.length();

        // 出现次数最多的字母
        int maxChar = 0;
        // 可替换字母的个数，随着指针移动，如果temCHar大于0且能被4整数，当前范围满足条件，
        // 左指针右移一格，否则右指针右移
        int temChar = 0;
        map.put(input.charAt(0),map.get(input.charAt(0)) -1);
        while (true) {
            maxChar = Math.max(Math.max(map.get('W'),map.get('A')),Math.max(map.get('S'),map.get('D')));
            length = right -left +1;
            temChar = length - ((maxChar - map.get('W')) +(maxChar - map.get('A')) +(maxChar - map.get('S')) +(maxChar - map.get('D')));
            if (temChar >= 0 && temChar % 4 == 0) {
                if (length < res) {
                    res = length;
                }
                map.put(input.charAt(left),map.get(input.charAt(left)) +1);
                left++;
            } else {
                right++;
                map.put(input.charAt(right),map.get(input.charAt(right)) -1);
            }
            //
            if (right >= input.length() -1) {
                break;
            }
        }
        System.out.println(res);

    }

}
