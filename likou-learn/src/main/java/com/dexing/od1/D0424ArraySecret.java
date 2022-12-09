package com.dexing.od1;

import java.util.HashSet;

/**
 * 在一行中输入一个字符串数组，如果其中一个字符串的所有以索引0开头的子串在数组中都有，那么这个字符串就是潜在密码，在所有潜在密码中最长的是真正的密码，如果有多个长度相同的真正的密码，那么取字典序最大的为唯一的真正的密码，求唯一的真正的密码。
 *  示例1：
 *  输入： h he hel hell hello o ok n ni nin ninj ninja
 *  输出： ninja
 *  说明： 按要求，hello、ok、ninja都是潜在密码。检查长度，hello、ninja是真正的密码。检查字典序，ninja是唯一真正密码。
 *  示例2:
 *  输入： a b c d f
 *  输出： f
 *  说明： 按要求，a b c d f 都是潜在密码。检查长度，a b c d f 是真正的密码。检查字典序，f是唯一真正密码。
 */
public class D0424ArraySecret {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        String[] split = "h he hel hell hello o ok n ni nin ninj ninja".split("\\s+");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            set.add(split[i]);
        }
        // 真正的密码
        String truePassWord ="";
        for (String str : split) {
            // 条件1：检查这个词所有以0开头的子串在数组中是否都有
            boolean flag = true;
            for (int i = 1; i < str.length(); i++) {
                // 以索引0开头的子串
                String substring = str.substring(0, i);
                if (!set.contains(substring)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                // 条件2：比较密码长度
                if (str.length() > truePassWord.length()) {
                    truePassWord = str;
                }
                // 条件3；比较密码字典排序
                if (str.length() == truePassWord.length() && str.compareTo(truePassWord) > 0) {
                    truePassWord = str;
                }
            }
        }

        System.out.println(truePassWord);
    }
}
