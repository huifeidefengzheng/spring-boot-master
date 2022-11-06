package com.dexing.od;

import java.util.Scanner;

/**
 * 25.【分糖果】
 *
 * 题目描述:
 *
 * 小明从糖果盒中随意抓一把糖果 每次小明会取出一半的糖果分给同学们 当糖果不能平均分配时 小明可以从糖果盒中(假设盒中糖果足够)取出一个或放回一个糖果 小明至少需要多少次(取出放回和平均分配均记一次)能将手中糖果分至只剩一颗
 *
 * 示例：
 * 输入 ：15 输出： 5
 * 解释：
 * 15 +1 = 16
 * 16 / 2 = 8
 * 8/2=4
 * 4/2=2
 * 2/2 =1
 *
 * 输入 ：4 输出：2
 *
 * 理解：当抓出来的糖果数量m为偶数时，是2^n时，一直除2，除2的次数就是分糖的次数；
 * 如果是奇数，m-1/2 对2在求余数==0说明是2^n倍，或者是m+1是2^n倍
 *
 *
 */
public class D0822CandySplit {

    public static void main(String[] args) {
        System.out.println(6%2);
        my(15);
    }

    public static void my(int n) {
        int count = 0;
        while (n > 1) {
            count++;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                // 数越小，说明奇数数量越少
                if (n == 3 || (n - 1) / 2 % 2 == 0) {
                    n--;
                } else {
                    n++;
                }
            }
        }
        System.out.println(count);
    }

    public static void test( ) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(handle(num));

    }
    private static int handle(int tang){
        if (tang == 1){
            return 0;
        }
        if (tang % 2 == 0){
            tang /= 2;
            //次数+1
            return handle(tang)+1;
        }
        int plus = handle(tang +1) +1;//增加一个
        int sub = handle(tang -1) +1;//减少一个
        return Math.min(plus,sub);
    }
}
