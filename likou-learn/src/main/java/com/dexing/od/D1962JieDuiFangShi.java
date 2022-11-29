package com.dexing.od;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 用一个数组A代表程序员的工作能力，公司想通过结对编程的方式提高员工的能力，假设结对后的能力为两个员工的能力之和，求一共有多少种结对方式使结对后能力为N。
 * 输入描述:
 * 5
 * 1 2 2 2 3
 * 4
 * 第一行为员工的总人数，取值范围[1,1000]
 * 第二行为数组A的元素，每个元素的取值范围[1,1000]
 * 第三行为N的值，取值范围[1,1000]
 * 输出描述:
 * 4
 * 满足结对后能力为N的结对方式总数
 * 示例1
 * 输入
 * 5
 * 1 2 2 2 3
 * 4
 * 输出
 * 4
 * 说明
 * 满足要求的结对方式为：A[0]和A[4]，A[1]和A[2]，A[1]和A[3]，A[2]和A[3]
 */
public class D1962JieDuiFangShi {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
//        Scanner scanner = new Scanner(System.in);
//        Integer Pnum = scanner.nextInt();
//        int N = Integer.parseInt(scanner.nextLine());

        Integer Pnum = 5;

        String s = "1 2 2 2 3";
        int N = 4;
        String[] strings = s.split("\\s+");
        ArrayList<Integer> integers = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < Pnum; i++) {
            integers.add(Integer.parseInt(strings[i]));
        }
        for (int i = 0; i < Pnum; i++) {
            for (int j = i+1; j < Pnum; j++) {
                if ((integers.get(i) + integers.get(j) ) == N) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
