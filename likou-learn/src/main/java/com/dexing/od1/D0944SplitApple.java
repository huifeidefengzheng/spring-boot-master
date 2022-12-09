package com.dexing.od1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【分苹果】
 * A、B两个人把苹果分为两堆，
 * A希望按照他的计算规则等分苹果，他的计算规则是按照二进制加法计算，并且不计算进位 12+5=9（1100 + 0101 = 9），
 * B的计算规则是十进制加法，包括正常进位，B希望在满足A的情况下获取苹果重量最多。
 * 输入苹果的数量和每个苹果重量，输出满足A的情况下B获取的苹果总重量。
 * 如果无法满足A的要求，输出-1。
 * 数据范围
 * 1 <= 总苹果数量 <= 20000
 * 1 <= 每个苹果重量 <= 10000
 * 输入描述：
 * 输入第一行是苹果数量：3
 * 输入第二行是每个苹果重量：3 5 6
 * 输出描述：
 * 输出第一行是B获取的苹果总重量：11
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 3
 * 3 5 6
 * 输出
 * 11
 * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 8
 * 7258 6579 2602 6716 3050 3564 5396 1773
 * 输出
 * 35165
 *
 *
 *  1：先审题，A的目标是 等分，也就是目标是一人一半。 
 *  2：不进位的二进制加法，等同于二进制的异或操作。
 *  3：B要先满足 A 的 需求，那么肯定要先判定所有苹果在不进位的二进制加法前提下能否等分，等分那就意味着分出来的两堆苹果异或的结果为 0。 
 *  4：如果可以等分，那么取出最小的苹果分给 A 即可。因为所有苹果异或的结果是0，所以任意拿出1个，分成另一堆， 那么这两堆的重量，按照A的算法去算，必然是相等的 （不信可以试一试）。 
 *  5：如果不能等分，则直接返回 -1。
 */
public class D0944SplitApple {
    public static void main(String[] args) {
        int a1 = 5; // 0000 0101
        int b1 = 3; // 0000 0011
        a1 |= b1; // 0000 00111
        System.out.println("|= "+a1);

        int a2 = 5; // 0000 0101
        int b2 = 3; // 0000 0011
        a2 &= b2; // 0000 0001
        System.out.println("&= "+a2);

        int a3 = 5; // 0000 0101
        int b3 = 3; // 0000 0011
        a3 ^= b3; // 0000 0110
        System.out.println("^= "+a3);

    }

    public static void test() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = Integer.parseInt(in.nextLine());
            List<Integer> weights = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                weights.add(in.nextInt());
            }

            int aWeight = 0;
            int bWeight = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < num; i++) {
                //不进位的二进制加法，等同于二进制的异或操作。
                aWeight ^= weights.get(i);
                bWeight += weights.get(i);
                min = Math.min(i, min);
            }

            if (aWeight == 0) {
                System.out.println(bWeight - min);
            } else {
                System.out.println(-1);
            }
        }
    }

    /**
     * |=：两个二进制对应位都为0时，结果等于0，否则结果等于1；
     *
     * &=：两个二进制的对应位都为1时，结果为1，否则结果等于0；
     *
     * ^=：两个二进制的对应位相同，结果为0，否则结果为1。
     */
    public static void tt() {
        int a1 = 5; // 0000 0101
        int b1 = 3; // 0000 0011
        a1 |= b1; // 0000 00111
        System.out.println("|= "+a1);

        int a2 = 5; // 0000 0101
        int b2 = 3; // 0000 0011
        a2 &= b2; // 0000 0001
        System.out.println("&= "+a2);

        int a3 = 5; // 0000 0101
        int b3 = 3; // 0000 0011
        a3 ^= b3; // 0000 0110
        System.out.println("^= "+a3);
    }
}
