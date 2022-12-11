package com.dexing.od;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 24.【查找众数及中位数】
 * 题目描述：
 * 1.众数是指一组数据中出现次数量多的那个数，众数可以是多个
 * 2.中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，
 * 如果这组数据的个数为偶数，那就把中间的两个数之和除以 2，所得的结果就是中位数
 * 3.查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数
 * 输入描述：
 * 输入一个一维整型数组，数组大小取值范围 0 < N < 1000，数组中每个元素取值范围 0 < E < 1000
 * 输出描述：
 * 输出众数组成的新数组的中位数
 * 示例 1：
 * 输入
 * 10 11 21 19 21 17 21 16 21 18 15
 * 输出
 * 21
 * 
 *  示例2  输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4 
 *  输出 
 *  3 
 *  示例3  输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39 
 *  输出 
 *  7 
 */
public class D0821ZhongShu {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String str = "2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4";
        String[] s = str.split(" ");
        ArrayList<Integer> integers = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            int anInt = Integer.parseInt(s[i]);
            Integer integer = map.get(anInt);
            if (integer == null) {
                map.put(anInt,1);
            } else {
                map.put(anInt,integer+1);
            }
        }

        // 按出现次数排序
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int max = 0;
        // 获取众数列表
        List<Integer> mode = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() >= max) {
                mode.add(entry.getKey());
                max = entry.getValue();
            }
        }
        // 计算中位数
        int medium = 0;
        int length = mode.size();
        if (length % 2 == 0) {
            medium = (mode.get(length / 2 - 1) + mode.get(length / 2)) / 2;
        } else {
            medium = mode.get(length / 2);
        }
        System.out.println(medium);


    }
}
