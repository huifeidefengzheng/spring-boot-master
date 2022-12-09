package com.dexing.od1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 篮球(5V5)比赛中，每个球员拥有一个战斗力，每个队伍的所有球员战斗力之和为该队伍的总体战斗力。
 * 现有10个球员准备分为两队进行训练赛，教练希望2个队伍的战斗力差值能够尽可能的小，以达到最佳训练效果。
 * 给出10个球员的战斗力，如果你是教练，你该如何分队，才能达到最佳训练效果?请说出该分队方案下的最小战斗力差值。
 * 输入描述:
 *  10个篮球队员的战斗力(整数，范围[1,10000]),战斗力之间用空格分隔，如:10987654321
 *  不需要考虑异常输入的场景。
 *  输出描述:
 *  最小的战斗力差值，如:1
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  10 9 8 7 6 5 4 3 2 1
 *  输出
 *  1
 *  说明：
 *  1 2 5 9 10分为一队，3 4 6 7 8分为一队，两队战斗力之差最小，输出差值1。
 *  备注：球员分队方案不唯一，但最小战斗力差值固定是1。
 */
public class D0839Baskball {
    public static boolean[] is_visited;
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] num_strs = str.split(" ");
        int[] num = new int[num_strs.length];
        for (int i = 0; i < num_strs.length; i++) {
            num[i] = Integer.parseInt(num_strs[i]);
        }
        int sum = 0;
        is_visited = new boolean[10];

        for (int k : num) {
            sum += k;
        }
        for (int min = 0; min <= sum; min++) {
            int target = (sum - min);
            if (target % 2 == 0) {
                if (dfs(target / 2, num, 0)) {
                    System.out.println(min);
                    break;
                }
            }
        }
    }

    private static boolean dfs(int target, int[] arr, int index) {
        int length = arr.length;
        if (index > 5 || target < 0) {
            return false;
        }

        if (index == 5 && target == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (is_visited[i]) {
                continue;
            }
            is_visited[i] = true;
            if (dfs(target - arr[i], arr, index + 1)) {
                return true;
            }
            is_visited[i] = false;
        }
        return false;
    }

    public static void test() {
        List<Integer> list = Arrays.asList("10 9 8 7 6 5 4 3 2 1".split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(list);


    }
}
