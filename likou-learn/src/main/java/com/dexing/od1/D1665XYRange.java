package com.dexing.od1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 给定坐标轴上的一组线段，线段的起点和终点均为整数并且长度不小于1，请你从中找到最少数量的线段，这些线段可以覆盖住所有线段。
 * 输入描述
 * 第一行输入为所有线段的数量，不超过10000，后面每行表示一条线段，格式为”x,y”，
 * x和y 分别表示起点和终点，取值范围是[-10^5，10^5]。
 * 输出描述
 * 最少线段数量，为正整数。
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 3
 * 1,4
 * 2,5
 * 3,6
 * 输出
 * 2
 * 思路：
 *  1：又是一个典型的区间问题，先将所有线段按起点从小到大排序。 
 *  2：逐个选取每一个线段，将其作为开始的线段，再找出剩余的线段中左端点小于等于开始线段的右端点中（若没有则无解），找出右端点最大的一个线段，起始就是贪心算法。
 *  其右端点越大，其右端覆盖到的地方也就最优。反复重复上一步，直到覆盖完整个长度为m的区间，就能得到最少的线段数。
 */
public class D1665XYRange {
    public static int min_num;

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String count = in.nextLine();

        //自定义排序
        ArrayList<ArrayList<Integer>> ranges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < Integer.valueOf(count); i++) {
            ArrayList<Integer> range = new ArrayList<Integer>();
            String[] nums = in.nextLine().split(",");
            range.add(Integer.valueOf(nums[0]));
            range.add(Integer.valueOf(nums[1]));
            ranges.add(range);
        }
        Collections.sort(ranges, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int result = o1.get(0) - o2.get(0);
                if (result == 0) {
                    return o1.get(1) - o2.get(1);
                }
                return result;
            }
        });


        int total_length = ranges.get(ranges.size() - 1).get(1) - ranges.get(0).get(0);
        //System.out.println(total_length);

        //区间起点
        int start = 0;
        min_num = ranges.size();
        for (int i = 0; i < Integer.valueOf(count); i++) {
            start = ranges.get(i).get(0);
            find_min_line(ranges, i, 1, start, total_length);
        }
        System.out.println(min_num);
    }

    public static void find_min_line(ArrayList<ArrayList<Integer>> ranges, int index, int ans, int start, int total_length) {
        // 完全覆盖
        if (ranges.get(index).get(1) - start >= total_length) {
            min_num = Math.min(min_num, ans);
            return;
        }
        int temp = 0;
        for (int i = index + 1; i < ranges.size(); i++) {
            // 找出剩余线段中左端点小于起始线段的右端点；
            if (ranges.get(i).get(0) <= ranges.get(index).get(1)) {
                // 剩余线段右端点大于起始右端点
                if (ranges.get(i).get(1) > ranges.get(temp).get(1))
                    temp = i;
            } else {
                break;
            }
            if (temp != 0) {
                find_min_line(ranges, temp, ans + 1, start, total_length);
            }
        }
    }
}
