package com.dexing.od1;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 有一堆长方体积木，它们的长度和宽度都相同，但长度不一。
 *
 * 小橙想把这堆积木叠成一面墙，墙的每层可以放一个积木，也可以将拼接多个积木，要求每层的长度相同。最少2层。
 *
 * 若必须用完这些积木，叠成的墙最多为多少层？
 *
 * 输入描述
 * 输入为一行，为各个积木的长度，数字为正整数，并由空格分隔。积木的数量和长度都不超过5000。
 *
 * 输出描述
 * 输出一个数字，为墙的最大层数，如果无法按要求叠成每层长度一致的墙，则输出-1。
 * 示例
 * 输入
 * 3 6 3 3 3
 * 输出
 * 3
 * 解释：以 6 为底的墙，第一层为 6 ，第二层为 3 + 3，第三层 3 + 3。
 *
 * 输入
 * 9 9 9 5 3 2 2 2 2 2
 * 输出
 * 5
 * 解释：
 * 5+2+2=9
 * 3+2+2+2=9
 * 9,9,9
 * 共五层
 *
 * 输入
 * 3 5
 * 输出
 * -1
 */
public class D0301DieJimu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        Arrays.sort(nums);

        int res = -1;
        for (int i = 2; i <= sum / 2; i++) {
            if (sum % i != 0) continue;
            int score = sum / i;
            if(nums[nums.length - 1] > score){
                continue;
            }
            //建立一个长度为k的桶
            int[] arr = new int[i];
            //桶的每一个值都是子集的和
            Arrays.fill(arr, score);
            if (dfs (nums, nums.length - 1, 0, arr, i, score)) {
                res = Math.max(res, i);
            }
        }
        System.out.println(res);
    }

    public static boolean dfs(int[] nums, int cur, int used, int[] arr, int k, int score) {
        //已经遍历到了-1说明前面的所有数都正好可以放入桶里，那所有桶的值此时都为0，说明找到了结果，返回true
        if (cur < 0) {
            return true;
        }
        if (used < k) {
            arr[used] = nums[cur];
            if (dfs(nums, cur - 1, used + 1, arr, k, score)) {
                return true;
            }
            arr[used] = 0;
        }
        //遍历k个桶
        for (int i = 0; i < used; i++) {
            // 如果当前桶和上一个桶内的元素和相等，则跳过
            // 原因：如果元素和相等，那么 nums[cur] 选择上一个桶和选择当前桶可以得到的结果是一致的
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            if (arr[i] + nums[cur] <= score) {
                arr[i] += nums[cur];
                if (dfs(nums, cur - 1, used, arr, k, score)) return true;
                arr[i] -= nums[cur];
            }
        }
        return false;
    }

}
