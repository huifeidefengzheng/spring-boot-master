package com.dexing.od;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 13.【打印任务排序】
 * 题目描述
 * 某个打印机根据打印队列执行打印任务。打印任务分为九个优先级，分别用数字1-9表示，数字越大优先级越高。打印机每次从队列头部取出第一个任务A，
 * 然后检查队列余下任务中有没有比A优先级更高的任务，如果有比A优先级高的任务，则将任务A放到队列尾部，否则就执行任务A的打印。
 * 请编写一个程序，根据输入的打印队列，输出实际的打印顺序。
 * 输入描述
 * 输入一行，为每个任务的优先级，优先级之间用逗号隔开，优先级取值范围是1~9。
 * <p>
 * 输出描述
 * 输出一行，为每个任务的打印顺序，打印顺序从0开始，用逗号隔开
 * <p>
 * 示例
 * 输入
 * 9,3,5
 * 输出
 * 0,2,1
 * <p>
 * 队列头部任务的优先级为9，最先打印，故序号为0；
 * 接着队列头部任务优先级为3，队列中还有优先级为5的任务，优先级3任务被移到队列尾部；
 * 接着打印优先级为5的任务，故其序号为1；
 * 最后优先级为3的任务的序号为2。
 * 输入
 * 1,2,2
 * 输出
 * 2,0,1
 */
public class D0411PrintOrder {
    public static void main(String[] args) {
        int[] aa = {2, 4, 1, 5, 3, 9, 8};
        System.out.println(printTaskOrder("7,9,7"));

    }

    public static void printTaskOrder(int[] aa) {
        Queue<Integer> queue = new ArrayDeque<>();
        PriorityQueue<int[]> prior = new PriorityQueue<>((a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));
        for (int i = 0; i < aa.length; i++) {
            queue.offer(aa[i]);
            prior.offer(new int[]{aa[i], i});
        }
        int dex = 0;
        int[] res = new int[aa.length];
        while (!queue.isEmpty()) {
            int poll1 = queue.poll();
            int[] poll2 = prior.poll();
            if (poll1 == poll2[0]) {
                // 按打印顺序存储结果
                res[poll2[1]] = dex;
                dex++;

            } else {
                queue.offer(poll1);
                prior.offer(poll2);
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i != res.length - 1) {
                System.out.print(",");
            }
        }
    }

    public static String printTaskOrder(String s) {

        String[] split = s.split(",");
        int[] res = new int[split.length];

        // 降序， 顶是优先级最大的， [0]是下标， [1]是优先级
        PriorityQueue<int[]> prior = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < split.length; i++) {
            prior.offer(new int[]{i, Integer.parseInt(split[i])});
        }

        int k = 0;
        while (!prior.isEmpty()) {
            int[] poll = prior.poll();
            res[poll[0]] = k;
            k++;
        }

        StringBuilder sb = new StringBuilder();
        for (int e : res) {
            sb.append(e).append(",");
        }

        return sb.substring(0, sb.length() - 1).toString();


    }

    public static void bubble(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void printOrder(int[] input, int[] output) {
        int temp = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = input.length; j > i; j--) {
                if (input[j] > input[j - 1]) {
                    temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                }
            }
        }
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }
    }
}
