package com.dexing.od1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  【补种未成活胡杨】
 *  近些年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨（编号1-N），排成一排。
 *  一个月后，有M棵胡杨未能成活。
 *  现可补种胡杨K棵，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？
 *  输入描述
 *  N 总种植数量
 *  M 未成活胡杨数量
 *  M 个空格分隔的数，按编号从小到大排列
 *  K 最多可以补种的数量
 *  其中：
 *  1 <= N <= 100000
 *  1 <= M <= N
 *  0 <= K <= M
 *  输出描述
 *  最多的连续胡杨棵树
 *
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  5
 *  2
 *  2 4
 *  1
 *  输出
 *  3
 *  说明
 *  补种到2或4结果一样，最多的连续胡杨棵树都是3。
 *
 *  示例2
 *  输入
 *  10
 *  3
 *  2 4 7
 *  1
 *  输出
 *  6
 *  说明 补种第7棵树，最多的连续胡杨棵树为6(5,6,7,8,9,10)
 */
public class D0942HuYangShu {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        // 输入处理
        /*Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int M = Integer.parseInt(in.nextLine());*/
        int N = 10;
        int M = 3;

        // 未成活坐标
//        String[] dead_pos_str_list = in.nextLine().split(" ");
        String[] dead_pos_str_list = "2 4 7".split(" ");
        int[] dead_pos  = new int[M];
        for (int i = 0; i < M; i++) {
            dead_pos[i] = Integer.parseInt(dead_pos_str_list[i]);
        }

        int K = 1;

        // 滑动窗口，保证中间有K棵树补种
        int max = 0;
        for (int i = 0; i <= dead_pos.length - K; i++) {
            int left = 0;
            int right = N;
            if (i > 0) {
                left = dead_pos[i - 1];
            }

            if (i + K < dead_pos.length) {
                right = dead_pos[i + K] - 1;
            }

            int temp = right - left;
            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);
    }

    public static void test() {
        int n = 5;
        int m = 2;
        List<Integer> list = Arrays.asList("2 4".split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int k = 1;
        int[] arr = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            if (list.contains(i)) {
                continue;
            }
            arr[i]= i;
        }
        int max = 0;
        for (int i = 1; i < n +1; i++) {
            int tem = i;
            int ktem = 0;
            while (tem <= i + k && i + k < n +1) {
                if (arr[tem] == 0) {
                    ktem++;
                }
                tem ++;
            }
            if (ktem == k) {
                max = Math.max(max,check(arr,k,i,n));
            }
        }
        System.out.println(max);


    }

    private static int check(int[] arr, int k, int i,int n) {
        int tem = i;
        while (tem <= i + k && i + k < n +1) {
            if (arr[tem] == 0) {
               arr[tem] = -1;
            }
            tem ++;
        }
        int max = 0,count=0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != 0) {
                count++;
            } else {
                max = Math.max(max,count);
                count=0;
            }
        }
        int ttem = i;
        while (ttem <= i + k && i + k < n +1) {
            if (arr[ttem] == -1) {
                arr[ttem] = 0;
            }
            ttem ++;
        }
        return max;
    }
}
