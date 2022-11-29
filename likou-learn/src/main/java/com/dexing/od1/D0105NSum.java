package com.dexing.od1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 * 说明：
 * *数组中数字范围[0, 1000]
 * *最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
 * *输入非法返回-1
 * 输入描述:
 * 第一行输入M， M标识数组大小
 * 第二行输入M个数，标识数组内容
 * 第三行输入N，N表达需要计算的最大、最小N个数
 * 输出描述:
 * 输出最大N个数与最小N个数的和。
 * 示例1
 * 输入
 * 5
 * 95 88 83 64 100
 * 2
 * 输出
 * 342
 * 说明
 * 最大2个数[100,95],最小2个数[83,64], 输出为342
 * 示例2
 * 输入
 * 5
 * 3 2 3 4 2
 * 2
 * 输出
 * -1
 * 说明
 * 最大2个数[4,3],最小2个数[3,2], 有重叠输出为-1
 */
public class D0105NSum {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] split = "95 88 83 64 100".split("\\s+");
        int n = 2;
        if (n> split.length) {
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            int i1 = Integer.parseInt(split[i]);
            if (!list.contains(i1)) {
                list.add(i1);
            }
        }
        list.sort((v1,v2) -> v2-v1);

        List<Integer> maxArr = list.subList(0,n);
        List<Integer> minArr = list.subList(list.size() -n,list.size());
        int tt = 0;
        for (int i = 0; i < n; i++) {
            int i1 = maxArr.get(i);
            Integer integer = minArr.get(i);
            if (minArr.contains(i1)) {
                System.out.println(-1);
                return;
            }
            tt += i1+integer;
        }
        System.out.println(tt);
    }

}
