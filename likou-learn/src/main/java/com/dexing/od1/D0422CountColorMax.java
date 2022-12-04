package com.dexing.od1;

import java.util.HashMap;
import java.util.Map;


/**
 * 题目内容 在一个狭小的路口，每秒只能通过一辆车，假好车辆的颜色只有 3 种，找出 N 秒内经过的最多颜色的车辆数量。
 *  三种颜色编号为0 ，1 ，2
 *  输入描述 第一行输入的是通过的车辆颜色信息
 *  [0,1,1,2] 代表4 秒钟通过的车辆颜色分别是 0 , 1 , 1 , 2
 *  第二行输入的是统计时间窗，整型，单位为秒
 *  输出描述 输出指定时间窗内经过的最多颜色的车辆数量。
 *  样例 样例一： 输入
 *  0 1 2 1 3 输出
 *  2
 *  样例解释
 *  在 3 秒时间窗内，每个颜色最多出现 2 次。例为：[1,2,1]
 *   样例二： 输入
 *  0 1 2 1
 *  2 输出
 *  1
 *  样例解释
 *  在 2 秒时间窗内，每个颜色最多出现1 次。
 */
public class D0422CountColorMax {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] s = "0 1 2 1".split(" ");
        int w = 2;
        int[] ints = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            ints[i] = Integer.parseInt(s[i]);
        }
        int start = 0, end = ints.length - 1,res =0;
        while (start <= end) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = start - w + 1; i <= start && start + 1 >= w; i++) {
                int anInt = ints[i];
                Integer orDefault = map.getOrDefault(anInt, 0);
                map.put(anInt,orDefault+1);
            }
            if (map.size()>0) {
                res = Math.max(checkMax(map),res);
            }
            start++;
        }
        System.out.println(res);
    }

    private static int checkMax(HashMap<Integer, Integer> map) {
        int max = 0;
        for (Map.Entry<Integer,Integer> ma : map.entrySet()) {
            max = Math.max(ma.getValue(),max);
        }
        return max;
    }
}
