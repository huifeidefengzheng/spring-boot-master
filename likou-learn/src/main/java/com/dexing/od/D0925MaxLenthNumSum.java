package com.dexing.od;

import java.util.ArrayList;

/**
 * 29.【最长的连续子序列】
 * 题目描述：
 *
 * 有N个正整数组成的一个序列
 * 给定一个整数sum
 * 求长度最长的的连续子序列使他们的和等于sum
 * 返回次子序列的长度
 * 如果没有满足要求的序列 返回-1
 * 案例1：
 * 输入
 * 1,2,3,4,2
 * 6
 * 输出
 * 3
 * 解析：1,2,3和4,2两个序列均能满足要求
 * 所以最长的连续序列为1,2,3 因此结果为3
 */
public class D0925MaxLenthNumSum {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String str = "1,2,3,4,2";
        int total = 6;
        String[] split = str.split(",");
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            integers.add(Integer.parseInt(split[i]));
        }
        int maxLen = 0;
        for (int i = 0; i < integers.size(); i++) {
            int tem = 0,cou = 0;
            int sum = 0;
            while (tem <= i) {
                sum = integers.get(tem) + sum;
                if (sum == total) {
                    maxLen = Math.max(maxLen,++cou);
                    cou = 0;
                } else if (sum < total) {
                    cou ++;
                } else {
                    cou = 0;
                }
                tem ++;
            }
        }
        System.out.println(maxLen);

    }
}
