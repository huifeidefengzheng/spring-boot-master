package com.dexing.od1;

/**
 * 小明在学习二进制时，发现了一类不含 101的数，也就是：
 *  将数字用二进制表示，不能出现 101 。 现在给定一个整数区间 [l,r] ，请问这个区间包含了多少个不含 101 的数？
 *  输入描述 输入的唯一一行包含两个正整数 l， r（ 1 ≤ l ≤ r ≤ 10^9）。
 *  输出描述 输出的唯一一行包含一个整数，表示在 [l,r] 区间内一共有几个不含 101 的数。
 *  样例 样例一：
 *  输入
 *  1 10
 *  输出
 *  8 样例解释
 *  区间 [1,10] 内， 5 的二进制表示为 101 ，10的二进制表示为 1010 ，因此区间 [ 1 , 10 ] 内有 10−2=8 个不含 101的数。
 *
 *  样例二：
 *  输入
 *  10 20
 *  输出
 *  7
 *  样例解释
 *  区间 [10,20] 内，满足条件的数字有 [12,14,15,16,17,18,19] 因此答案为 7。
 */
public class D0421NotIncloud101 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int start = 10;
        int end = 20;
        int count = 0;
        for (int i = start; i <= end; i++) {
            String s = Integer.toBinaryString(i);
            if (!s.contains("101")){
                count++;
            }
        }
        System.out.println(count);
    }
}
