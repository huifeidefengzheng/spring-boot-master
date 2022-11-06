package com.dexing.od;

import java.util.Scanner;

/**
 * 10.【停车场车辆统计】
 * 题目描述：
 * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。
 * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。
 * 统计停车场最少可以停多少辆车，返回具体的数目。
 * 输入描述:
 * 整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
 * <p>
 * 输出描述：
 * 整型数字字符串，表示最少停车数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * 1,0,1
 * 输出
 * 2
 * 说明
 * 1个小车占第1个车位
 * 第二个车位空
 * 1个小车占第3个车位
 * 最少有两辆车
 * 示例 2：
 * <p>
 * 输入
 * 1,1,0,0,1,1,1,0,1
 * 输出
 * 3
 * 说明
 * 1个货车占第1、2个车位
 * 第3、4个车位空
 * 1个卡车占第5、6、7个车位
 * 第8个车位空
 * 1个小车占第9个车位
 * 最少3辆车
 */
public class D0308CarStationCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        String s = "";
        for (String st : str) {
            s += st;
        }
        String[] newStr = s.split("0");
        int count = 0;
        for (int i = 0; i < newStr.length; i++) {
            int length = newStr[i].length();
            if (length == 0) {
                continue;
            }
            // 当前位置如果停了
            if (length % 3 != 0) {
                count += (length - length % 3) / 3 + 1;
            } else {
                count += length / 3;
            }
        }
        System.out.println(count);
    }
}
