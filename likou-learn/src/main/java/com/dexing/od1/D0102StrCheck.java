package com.dexing.od1;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。判定S是否是L的有效字串。
 * 判定规则：S中的每个字符在L中都能找到（可以不连续），且S在Ｌ中字符的前后顺序与S中顺序要保持一致。（例如，S="ace"是L="abcde"的一个子序列且有效字符是a、c、e，而"aec"不是有效子序列，且有效字符只有a、e）
 * 输入描述:
 * 输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。
 * 先输入S，再输入L，每个字符串占一行。
 * 输出描述:
 * S串最后一个有效字符在L中的位置。（首位从0开始计算，无有效字符返回-1）
 * 示例1
 * 输入
 * ace
 * babcde
 * 输出
 * 5
 * 示例2
 * 输入
 * fgh
 * abcde
 * 输出
 * -1
 */
public class D0102StrCheck {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String s = "ace";
        String l = "babcde";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int tem = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (l.contains(String.valueOf(c))) {
                int i1 = l.indexOf(c);
                map.put(c,i1);
                if (i1 > tem) {
                    tem = i1;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(map.get(s.charAt(s.length()-1)));
    }
}
