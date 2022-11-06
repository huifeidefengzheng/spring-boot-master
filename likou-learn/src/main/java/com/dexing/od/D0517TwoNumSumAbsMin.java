package com.dexing.od;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个随机的整数（可能存在正整数和负整数）数组 nums ，请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值，并返回这个两个数（按从小到大返回）以及绝对值。
 * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 输入描述:
 *
 * 一个通过空格分割的有序整数序列字符串，最多1000个整数，且整数数值范围是 [-65535, 65535]。
 *
 * 输出描述:
 *
 * 两数之和绝对值最小值
 *
 * 示例1
 *
 * 输入
 *
 * -1 -3 7 5 11 15
 *
 * 输出
 *
 * -3 5 2
 *
 * 说明
 *
 * 因为 |nums[0] + nums[2]| = |-3 + 5| = 2 最小，所以返回 -3 5 2
 */
public class D0517TwoNumSumAbsMin {
    public static void main(String[] args) {
        int[] aa = {-1, -3, 7, 5, 11, 15};
        HashMap<Integer, int[]> integerHashMap = new HashMap<>();
        for (int i = 0; i < aa.length; i++) {
            for (int j = i+1; j <= aa.length -1; j++) {
                int abs = Math.abs(aa[i] + aa[j]);
                integerHashMap.put(abs,new int[]{aa[i]>aa[j]?aa[j]:aa[i],aa[i]>aa[j]?aa[i]:aa[j]});
            }
        }
        List<Integer> collect = integerHashMap.keySet().stream().sorted().collect(Collectors.toList());
        System.out.println(integerHashMap.get(collect.get(0))[0] +" " +integerHashMap.get(collect.get(0))[1] +" "+collect.get(0));
    }
}
