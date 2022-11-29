package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 高效的任务规划
 * 题目描述：
 * 你有 n 台机器编号为 1~n，每台都需要完成完成一项工作，机器经过配置后都能完成独立完成一项工作。
 * 假设第 i 台机器你需要花 B 分钟进行设置，然后开始运行，J 分钟后完成任务。
 * 现在，你需要选择布置工作的顺序，使得用最短的时间完成所有工作。
 * 注意，不能同时对两台机器进行配置，但配置完成的机器们可以同时执行它们各自的工作。
 * 注：此题对效率有要求，请考虑高效的实现方式
 *
 * 输入描述：
 * 第一行输入代表总共有 M 组任务数据（1<M<=10）。
 * 每组数第一行为一个整数，指定机器的数量 N（0<N<=1000）。
 * 随后的 N 行每行两个整数，第一个表示 B（0<=B<=10000），第二个表示 J（0<=J<=10000）。
 * 每组数据连续输入，不会用空行分隔。
 * 各组任务单独计时。
 * 输出描述：
 * 对于每组任务，输出最短完成时间，且每组的结果独占一行。
 * 例如，两组任务就应该有两行输出。
 * 示例 1：
 * 输入
 * 1
 * 1
 * 2 2
 * 输出
 * 4
 * 说明
 * 第一行1为一组任务，
 * 第二行1代表只有一台机器，
 * 第三行表示该机器配置需2分钟，执行需要2分钟。
 *
 *输入
 * 2
 * 2
 * 1 1
 * 2 2
 * 3
 * 1 1
 * 2 2
 * 3 3
 * 输出
 * 4
 * 7
 * 说明
 * 第一行2代表两组任务，
 * 第二行2代表第一组任务有2个机器，
 * 第三行1 1代表机器1配置需要1分运行需要1分，
 * 第四行2 2代表机器2配置需要2分运行需要2分，
 * 第五行3代表第二组任务需要3个机器，
 * 第6-8行分别表示3个机器的配置与运行时间。
 *
 *参考代码：
 * 解题思路：
 *
 * 题中要求总耗时最短，而且注意到题中：每次只能配置一台机器，那么一个简单道理就是让任务工作时间最长的机器先运行；
 * 最浅显的解释是：如果让任务工作时间最短的在前面运行，那么同段时间的时间利用率就不是最高，因此并行数量越多越好，这样才会获得总体最短时间；
 *
 * 动态规划：dp[i]表示当前机器工作完成经过的总时间。
 *
 */


public class D32100GaoXiaoTask {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int taskNum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < taskNum; i++) {
            int pu = Integer.parseInt(scanner.nextLine());
            int[][] mach = new int[pu][2];
            for (int j = 0; j < pu; j++) {
                String[] split = scanner.nextLine().split("\\s+");
                mach[i][0] = Integer.parseInt(split[0]);
                mach[i][1] = Integer.parseInt(split[1]);
            }
            int[] dp = new int[pu];
            int fix = 0,res =0;
            // 按照工作时间降序排列
            Arrays.sort(mach,(v1,v2)-> (v2[1]-v1[1]));
            for (int j = 0; j < pu; j++) {
                dp[i] = fix + mach[i][0] +mach[i][1];
                fix += mach[i][0];
                res = Math.max(dp[i],res );
            }
            System.out.println(res);

        }
    }

}
