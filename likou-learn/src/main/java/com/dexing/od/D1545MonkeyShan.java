package com.dexing.od;

import java.util.Scanner;

/**
 * 一天一只顽猴想去从山脚爬到山顶，途中经过一个有个N个台阶的阶梯，但是这猴子有一个习惯： 每一次只能跳1步或跳3步，试问猴子通过这个阶梯有多少种不同的跳跃方式？
 * 输入描述:
 * 输入只有一个整数N（0<N<=50）此阶梯有多少个阶梯
 * 输出描述:
 * 输出有多少种跳跃方式（解决方案数）
 * 示例1：
 * 输入
 * 50
 * 输出
 * 122106097
 * 示例2：
 * 输入
 * 3
 * 输出
 * 2
 *
 * 思路：
 *      当台阶大于等于3时，总有两种选择，
 */
public class D1545MonkeyShan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(calcCount(input));
    }

    private static int calcCount(int step){
        //只剩一个台阶了
        if (step < 3){
            return 1;
        }
        //剩下的场景都需要分成当前跳1步或者跳3步
        return calcCount(step -1) + calcCount( step -3);
    }
}
