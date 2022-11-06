package com.dexing.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述：
 * 给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，
 * 相同出现次数按照第一次出现顺序进行先后排序。
 * 输入描述：
 * 一个数组
 *
 * 输出描述：
 * 去重排序后的数组
 * 示例 1：
 * 输入
 * 1,3,3,3,2,4,4,4,5
 * 输出
 * 3,4,1,2,5
 * 备注
 * 数组大小不超过100 数组元素值大小不超过100
 */
public class D0413DistinctArray {
    public static void main(String[] args) {
        test13();

    }

    public static void test01() {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int[] ints = new int[str.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(str[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {  // 统计数字出现的频次
            map.put(ints[i], map.getOrDefault(ints[i], 0) + 1);
        }
        // Map按value排序，先将map转为list,再排序list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(entry.getKey() + ",");
            } else {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void test13() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        String[] arr = scanner.nextLine().split(",");
        for (String s : arr) {
            int val = Integer.parseInt(s);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        List<Integer> res = map.keySet().stream().sorted((x1, x2) -> map.get(x2) - map.get(x1))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        res.forEach(e -> sb.append(e).append(","));
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
