package com.dexing.od;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 删除字符串中出现次数最少的字符，如果有多个字符出现次数一样，则都删除。
 * 输入描述:
 * 输入abcdd
 * 字符串中只包含小写英文字母。
 * 输出描述:
 * dd
 * 示例1
 * 输入
 * abcdd
 * 输出
 * dd
 * 示例2
 * 输入
 * aabbccdd
 * 输出
 * empty
 * 说明
 * 如果字符串的字符都被删除，则范围empty
 */
public class D2066DeleteMinStr {
    public static void main(String[] args) {
        test();
    }

    public static void test21() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            int orDefault = map.getOrDefault(String.valueOf(input.charAt(i)), 0);
            map.put(String.valueOf(input.charAt(i)),orDefault+1);
        }
        int less = Collections.min(map.values());
        StringBuilder res = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (Map.Entry<String,Integer> mp:map.entrySet()) {
            int times = mp.getValue();
            if (times == less) {
                set.add(mp.getKey());
            }
        }
        for (int i = 0; i < input.length(); i++) {
            if (!set.contains(String.valueOf(input.charAt(i)))) {
                res.append(input.charAt(i));
            }
        }
        if (res.length() == 0){
            System.out.println("empty");
        }else {
            System.out.println(res);
        }


    }

    public static void test() {
        String str = "abcdd" ;
        ArrayList<Character> characters = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) != null) {
                Integer integer = map.get(c);
                map.put(c,++integer);
            } else {
                map.put(c,1);
            }
        }
        List<Map.Entry<Character, Integer>> list = map.entrySet().stream().sorted((v1, v2) -> v1.getValue() - v2.getValue()).collect(Collectors.toList());
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>();
        int start =0,left = list.size()-1;
        while (start < left) {
            if (list.get(start).getValue()<=list.get(left).getValue()) {
                entries.add(list.get(start));
                start++;
            } else {
                start++;
                left--;
            }
        }
        for (int i = 0; i < entries.size(); i++) {
            list.remove(entries.get(i));
        }
        String out = "";
        if (list.size() == 0) {
            System.out.println("empty");
        } else {
            for (int i = 0; i < list.size(); i++) {
                out += getStr(list.get(i));
            }
        }
        System.out.println(out);

    }

    private static String getStr(Map.Entry<Character, Integer> characterIntegerEntry) {
        Character key = characterIntegerEntry.getKey();
        Integer value = characterIntegerEntry.getValue();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < value; i++) {
            buffer.append(key);
        }
        return buffer.toString();
    }
}
