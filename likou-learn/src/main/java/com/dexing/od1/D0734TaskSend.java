package com.dexing.od1;

import java.util.Scanner;

/**
 * 【事件推送】
 *  同一个数轴X上有两个点的集合A={A1, A2, …, Am}和B={B1, B2, …, Bn}，Ai和Bj均为正整数，A、B已经按照从小到大排好序，
 *  A、B均不为空，给定一个距离R(正整数)，列出同时满足如下条件的所有（Ai, Bj）数对…
 *  1) Ai<= Bj
 *  2) Ai, Bj之间的距离小于等于R
 *  3) 在满足1) 2)的情况下,每个Ai只需输出距离最近的Bj
 *  4) 输出结果按Ai从小到大的顺序排序
 *  输入描述
 *  第一行三个正整数m,n,R
 *  第二行m个正整数,表示集合A
 *  第三行n个正整数,表示集合B
 *  输入限制
 *  1<=R<=100000, 1<=n,m<=100000, 1<=Ai,Bj<=1000000000
 *  输出描述
 *  每组数对输出一行Ai和Bj,以空格隔开
 *  示例1 &nbsp; 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  4 5 5
 *  1 5 5 10
 *  1 3 8 8 20
 *  输出
 *  1 1
 *  5 8
 *  5 8
 *
 */
public class D0734TaskSend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("\\s+");
        String[] mStrs = scanner.nextLine().split("\\s+");
        String[] nStrs = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(split[2]);
        for (int i = 0; i < mStrs.length; i++) {
            if (mStrs[i].trim().length() <= 0) {
                continue;
            }
            int i1 = Integer.parseInt(mStrs[i]);
            for (int j = 0; j < nStrs.length; j++) {
                if (nStrs[j].trim().length() <= 0) {
                    continue;
                }
                int i2 = Integer.parseInt(nStrs[j]);
                if (i1 <= i2) {
                    if (i2 - i1  <= r) {
                        System.out.println(i1 + " " + i2);
                    }
                    break;
                }
            }
        }
    }


    public static void test() {
        String[] split = "4 5 5".split("\\s+");
        String[] mStrs = "1 5 5 10".split("\\s+");
        String[] nStrs = "1 3 8 8 20".split("\\s+");
        int r = Integer.parseInt(split[2]);
        for (int i = 0; i < mStrs.length; i++) {
            if (mStrs[i].trim().length() <= 0) {
                continue;
            }
            int i1 = Integer.parseInt(mStrs[i]);
            for (int j = 0; j < nStrs.length; j++) {
                if (nStrs[j].trim().length() <= 0) {
                    continue;
                }
                int i2 = Integer.parseInt(nStrs[j]);
                if (i1 <= i2) {
                    if (i2 - i1  <= r) {
                        System.out.println(i1 + " " + i2);
                    }
                    break;
                }
            }
        }
    }

}
