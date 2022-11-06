package com.dexing.od;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定参数n，从1到n会有n个整数：1,2,3,…,n，这n个数字共有 n! 种排列。
 * 按大小顺序升序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * “123”
 * “132”
 * “213”
 * “231”
 * “312”
 * “321”
 * 给定 n 和 k，返回第 k 个排列。
 * 输入描述:
 * 输入两行，第一行为n，第二行为k，给定 n 的范围是 [1,9]，给定 k 的范围是[1,n!]。
 * 输出描述:
 * 输出排在第k位置的数字。
 * 示例1：
 * 输入
 * 3
 * 3
 * 输出
 * 213
 * 说明
 * 3的排列有123 132 213…，那么第3位置的为213
 * 示例2：
 * 输入
 * 2
 * 2
 * 输出
 * 21
 * 说明
 * 2的排列有12 21，那么第2位置的为21
 */
public class D1338KSorced {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
//        Scanner sc = new Scanner(System.in);
        int ni = 3;//[1,9]
        int kLine = 4;//[1,n!]
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= ni; i++) {
            list.add(i);
        }
        int idx = ni;
        StringBuilder sb = new StringBuilder();
        kLine--;//数组中，存在下标0，顾--
        while (list.size()>0){
            int total = 1;
            for (int i = idx-1; i > 0; i--) {
                total *= i;
            }
            int index = kLine/total;
            kLine = Math.max(kLine - total, 0);
            int res = list.get(index);
            sb.append(res);
            list.remove(index);
            idx--;
        }
        System.out.println(sb);
    }
}
