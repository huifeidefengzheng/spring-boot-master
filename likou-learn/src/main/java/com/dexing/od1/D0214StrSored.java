package com.dexing.od1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串重新排列
 *
 * 给定一个字符串s，s包括以空格分隔的若干个单词，请对s进行如下处理后输出：
 * 1、单词内部调整：对每个单词字母重新按字典序排序
 * 2、单词间顺序调整：
 * 	1）统计每个单词出现的次数，并按次数降序排列
 * 	2）次数相同，按单词长度升序排列
 * 	3）次数和单词长度均相同，按字典升序排列 请输出处理后的字符串，每个单词以一个空格分隔。
 * 输入描述： 一行字符串，每个字符取值范围：【a-zA-z0-9】以及空格，字符串长度范围：【1，1000】
 * 例1： 输入 This is an apple
 * 输出 an is This aelpp
 *
 *  例2：
 *  输入：
 *  My sister is in the house not in the yard
 *  输出：
 *  in in eht eht My is not adry ehosu eirsst
 */
public class D0214StrSored {
    public static void main(String[] args) {
        String[] split = "My sister is in the house not in the yard".split("\\s+");
        ArrayList<Word> words = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (map.containsKey(s)) {
                Integer integer = map.get(s);
                map.put(s,integer+1);
            } else {
                map.put(s,1);
            }
        }
        for (Map.Entry<String,Integer> ma : map.entrySet()) {
            Integer value = ma.getValue();
            String key = ma.getKey();
            char[] chars = key.toCharArray();
            Arrays.sort(chars);
            key = soredKey(chars);
            Word word = new Word(value, key.length(), key);
            words.add(word);
        }
        words.sort(null);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            appendWord(buffer,word);
        }
        System.out.println(buffer);
    }

    private static void appendWord(StringBuffer buffer, Word word) {
        for (int i = 0; i < word.count; i++) {
            buffer.append(word.getStr()).append(" ");
        }
    }

    private static String soredKey(char[] chars) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            buffer.append(chars[i]);
        }
        return buffer.toString();
    }

    static class Word implements Comparable<Word>{
        private Integer count;
        private Integer length;
        private String str;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public Word() {
        }

        public Word(Integer count, Integer length, String str) {
            this.count = count;
            this.length = length;
            this.str = str;
        }

        @Override
        public int compareTo(Word o) {
            if (this.count > o.count) {
                return -1;
            } else if (this.count == o.count) {
                if (this.length> o.length) {
                    return 1;
                } else if (this.length == o.length) {
                    return this.str.compareTo(o.str);
                } else {
                    return -1;
                }
            } else {
                return 1;
            }

        }
    }
}
