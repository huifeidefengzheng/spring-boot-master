package com.dexing.od1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的次数，并按照字母出现次数从大到小的顺序输出各个字母及其出现次数。如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
 * 输入描述:
 * 输入一行，为一个仅包含字母的字符串。
 * 输出描述:
 * 按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的分号；字母和次数间用英文冒号分隔。
 * 示例1
 * 输入
 * xyxyXX
 * 输出
 * x:2;y:2;X:2;
 * 说明
 * 每个字符出现的个数都是2，故x排在y之前，而小写字母x在X之前
 * 示例2
 * 输入
 * abababb
 * 输出
 * b:4;a:3;
 * 说明
 * b的出现个数比a多，故b排在a之前
 */
public class D0103StrCountSored {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String input = "xyxyXX";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            Integer integer = map.getOrDefault(c, 0);
            map.put(c,++integer);
        }
        ArrayList<StrIn> str = new ArrayList<>();
        for (Map.Entry<Character,Integer> ma : map.entrySet()) {
            str.add(new StrIn(ma.getKey(),ma.getValue()));
        }
        str.sort(null);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.size(); i++) {
            StrIn strIn = str.get(i);
            buffer.append(strIn.getCh()).append(":").append(strIn.getCount()).append(";");
        }
        String s = buffer.toString();
        System.out.println(s.substring(0,s.length()-1));
    }

    static class StrIn implements Comparable<StrIn>{
        private Character ch;
        private Integer count;

        public StrIn() {
        }

        public StrIn(Character ch, Integer count) {

            this.ch = ch;
            this.count = count;
        }

        public Character getCh() {
            return ch;
        }

        public void setCh(Character ch) {
            this.ch = ch;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        @Override
        public int compareTo(StrIn o) {
            if (this.count != o.count) {
                return o.count - this.count;
            }
            if (( this.ch>= 'a' && o.ch>= 'a') || (this.ch <= 'Z' && o.ch<= 'Z')){//相同是小写或者大写时
                return this.ch - o.ch;
            }else {//逆序排
                return o.ch - this.ch;
            }

        }
    }
}
