package com.dexing.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第 k 长的子串的长度，相同字母只取最长的那个子串。
 * 输入描述:
 * 第一行有一个子串(1<长度<=100)，只包含大写字母。
 * 第二行为 k的值
 * 输出描述:
 * 输出连续出现次数第k多的字母的次数。
 * 示例1
 * 输入
 * AAAAHHHBBCDHHHH
 * 3
 * 输出
 * 2
 * 说明
 * 同一字母连续出现的最多的是A和H，四次；第二多的是H，3次，但是H已经存在4个连续的，故不考虑；下个最长子串是BB，所以最终答案应该输出2。
 * 示例2
 * 输入
 * AABAAA
 * 2
 * 输出
 * 1
 * 说明
 * 同一字母连续出现的最多的是A，三次；第二多的还是A，两次，但A已经存在最大连续次数三次，故不考虑；下个最长子串是B，所以输出1
 * 示例3
 * 输入
 * ABC
 * 4
 * 输出
 * -1
 * 说明
 * 只含有3个包含同一字母的子串，小于k，输出-1
 * 示例4
 * 输入
 * ABC
 * 2
 * 输出
 * 1
 * 说明
 * 三个子串长度均为1，所以此时k = 1，k=2，k=3这三种情况均输出1。特此说明，避免歧义。
 * 备注:
 * 若子串中只包含同一字母的子串数小于k，则输出-1
 */
public class D1755LianxuZimuLength {
    public static void main(String[] args) {
        test();
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int k1 = Integer.parseInt(sc.nextLine());
        int[] arr = new int[26];
        int temp = 0;
        char pre = ' ';
        for (int i = 0; i < input.length(); i++) {
            if (i == 0){
                temp++;
                pre = input.charAt(i);
            }else if (input.charAt(i) == pre){
                temp++;
                int count = arr[pre - 'A'];
                arr[pre - 'A'] = Math.max(temp, count);
            }else {//换代
                temp = 1;
                pre = input.charAt(i);
                arr[input.charAt(i) - 'A'] = Math.max(temp, arr[input.charAt(i) - 'A'] );;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                list.add(arr[i]);
            }
        }
        list.sort((a1,b1) -> b1 - a1);
        if (list.size()< k1){
            System.out.println(-1);
        }else {
            System.out.println(list.get(k1-1));
        }
    }

    public static void test() {
        String str = "ABC" ;
        int k = 2;
        Deque<Zimu> deque = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (deque.size() > 0 && deque.peekLast().getCh() == aChar) {
                Zimu pop = deque.pollLast();
                pop.setCh(aChar);
                pop.setLen(pop.getLen()+1);
                deque.offer(pop);
            } else {
                deque.offer(new Zimu(aChar,1));
            }
        }
        List<Zimu> collect = deque.stream().sorted().collect(Collectors.toList());
        String st = "";
        for (int i = 0; i < collect.size(); i++) {
            Zimu zimu = collect.get(i);
            if (st.contains(zimu.getCh()+"")) {
                collect.remove(i);
            } else {
                st += zimu.getCh();
            }
        }
        if (k > collect.size()) {
            System.out.println(-1);
        } else {
            System.out.println(collect.get(k-1).getLen());
        }

    }

    static class Zimu implements Comparable<Zimu> {
        private Character ch;
        private Integer len;

        public Zimu(Character ch, Integer len) {
            this.ch = ch;
            this.len = len;
        }

        public Character getCh() {
            return ch;
        }

        public void setCh(Character ch) {
            this.ch = ch;
        }

        public Integer getLen() {
            return len;
        }

        public void setLen(Integer len) {
            this.len = len;
        }

        @Override
        public int compareTo(Zimu o) {
            return o.len - this.len;
        }
    }

}
