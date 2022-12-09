package com.dexing.od1;

import java.util.Arrays;
import java.util.List;

/**
 *  给定一个元素类型为小写字符串的数组，请计算两个没有相同字符的元素长度乘积的最大值，
 *  如果没有符合条件的两个元素，返回0。
 *  输入描述
 *  输入为一个半角逗号分隔的小写字符串的数组，2 <= 数组长度<=100，0 < 字符串长度<= 50。
 *  输出描述
 *  两个没有相同字符的元素 长度乘积的最大值。
 *
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  iwdvpbn,hk,iuop,iikd,kadgpf
 *  输出
 *  14
 *  说明
 *  数组中有5个元素。
 *  iwdvpbn与hk无相同的字符，满足条件，iwdvpbn的长度为7，hk的长度为2，乘积为14（7*2）。
 *  iwdvpbn与iuop、iikd、kadgpf均有相同的字符，不满足条件。
 *  iuop与iikd、kadgpf均有相同的字符，不满足条件。
 *  iikd与kadgpf有相同的字符，不满足条件。
 *  因此，输出为14。
 */
public class D0838NotSameStr {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        List<String> strings = Arrays.asList("iwdvpbn,hk,iuop,iikd,kadgpf".split(","));

        int max = 0;
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            for (int j = i +1; j < strings.size(); j++) {
                String s1 = strings.get(j);
                if (check(s,s1)) {
                    max = Math.max(max,s.length()*s1.length());
                }
            }
        }
        System.out.println(max);
    }

    private static boolean check(String s, String s1) {
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s1.contains(String.valueOf(s.charAt(i)))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
