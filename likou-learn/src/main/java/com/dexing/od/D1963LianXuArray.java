package com.dexing.od;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。
 * 输入描述:
 * 输入包含两个参数，1）连续正整数数列和S，2）数列里数的个数N。
 * 输出描述:
 * 如果有解输出数列K，如果无解输出-1
 * 示例1
 * 输入
 * 525 6
 * 输出
 * 85 86 87 88 89 90
 * 示例2
 * 输入
 * 3 5
 * 输出
 * -1
 */
public class D1963LianXuArray {
    public static void main(String[] args) {
        System.out.println(525/6);
        System.out.println(15/3);
    }

    public static void test2() {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int n = in.nextInt();
        // sum(x x+1 x+2 ... x+n-1) = sum
        // n*x + n*(n-1)/2 = sum
        // x= [sum - n*(n-1)/2 ]/n
        int temp = sum - n*(n-1)/2;
        if (temp <=0 || temp%n!=0){ // temp == n ???
            System.out.println(-1);
            return;
        }
        int begin = temp/n;
        for (int i = 0; i < n; i++) {
            System.out.print(begin+i);
            System.out.print(' ');
        }
    }

    public static void test() {
        String input = "525 6";
        String[] split = input.split("\\s+");
        int s = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int middle = 0 ,start = 0;
        if (s / n == 0) {
            System.out.println(-1);
            return;
        }
        int[] arr = new int[n];

        if (s % n == 0) {// n 奇数
            middle = s / n;
            start = middle - n /2;
        } else { // 偶数向下取正
            middle = s /n;
            start = middle - n/2 +1;
        }

        int indx = 0;
        while (indx < n) {
            arr[indx] = start;
            start++;
            indx ++;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum == s) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "");
            }
        } else {
            System.out.println(-1);
        }

    }
}
