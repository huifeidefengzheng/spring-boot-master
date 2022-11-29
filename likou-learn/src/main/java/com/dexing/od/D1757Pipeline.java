package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 一个工厂有m条流水线，来并行完成n个独立的作业，该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 * 现给定流水线个数m，需要完成的作业数n, 每个作业的处理时间分别为t1,t2…tn。请你编程计算处理完所有作业的耗时为多少？
 * 当n>m时，首先处理时间短的m个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 * 输入描述:
 * 第一行为2个整数（采用空格分隔），分别表示流水线个数m和作业数n；
 * 第二行输入n个整数（采用空格分隔），表示每个作业的处理时长t1,t2…tn。
 * 0< m,n<100，0<t1,t2…tn<100。
 * 注：保证输入都是合法的。
 * 输出描述:
 * 输出处理完所有作业的总时长
 * 示例1
 * 输入
 * 3 5
 * 8 4 3 2 10
 * 输出
 * 13
 * 说明
 * 1、先安排时间为2、3、4的3个作业。
 * 2、第一条流水线先完成作业，然后调度剩余时间最短的作业8。
 * 3、第二条流水线完成作业，然后调度剩余时间最短的作业10。
 * 4、总工耗时就是第二条流水线完成作业的时间13（3+10）。
 */
public class D1757Pipeline {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int m = 3,n = 5;
        String str = "8 4 3 2 10";
        String[] split = str.split("\\s+");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(ints);
        List<Integer> lists = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            int i1 = i % m;
            if (lists.size() ==  0 || i1 >= lists.size()) {
                lists.add(i1,ints[i]);
            } else {
                Integer integer = lists.get(i1);
                integer += ints[i];
                lists.set(i1,integer);
            }
        }
        List<Integer> collect = lists.stream().sorted((v1, v2) -> v2 - v1).collect(Collectors.toList());
        System.out.println(collect.get(0));
    }
}
