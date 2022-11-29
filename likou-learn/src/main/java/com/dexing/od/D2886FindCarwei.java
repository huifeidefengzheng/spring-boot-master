package com.dexing.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 停车场有一横排车位，0代表没有停车，1代表有车。至少停了一辆车在车位上，也至少有一个空位没有停车。
 * 为了防剐蹭，需为停车人找到一个车位，使得距停车人的车最近的车辆的距离是最大的，返回此时的最大距离。
 * 输入描述:
 * 1、一个用半角逗号分割的停车标识字符串，停车标识为0或1，0为空位，1为已停车。
 * 2、停车位最多100个。
 * 输出描述:
 * 输出一个整数记录最大距离。
 * 示例1
 * 输入
 * 1,0,0,0,0,1,0,0,1,0,1
 * 输出
 * 2
 * 说明
 * 当车停在第3个位置上时，离其最近的的车距离为2（1到3）。
 * 当车停在第4个位置上时，离其最近的的车距离为2（4到6）。
 * 其他位置距离为1。
 * 因此最大距离为2。
 */
public class D2886FindCarwei {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String input = "0,0,1,0,0,0,0,1,0,0,1,0,1";
        String[] split = input.split(",");
        int length = split.length;
        ArrayList<int[]> integers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int anInt = Integer.parseInt(split[i]);
            int start = i;
            while (anInt == 0) {
                start++;
                anInt = Integer.parseInt(split[start]);
            }
            if (start != i) {
                int wei = start - i;
                if (i == 0 && Integer.parseInt(split[i+1]) == 0) {
                    wei = wei-1;
                } else {
                    wei = wei-2;
                }
                if (wei == 0) {
                    int[] ints = {i,1};
                    integers.add(ints);
                } else if (wei > 0){
                    int[] ints = {i,wei};
                    integers.add(ints);
                }
            }
            i = start;
        }
        List<int[]> collect = integers.stream().sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        }).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(collect.get(0)[1]);
        }


    }



}
