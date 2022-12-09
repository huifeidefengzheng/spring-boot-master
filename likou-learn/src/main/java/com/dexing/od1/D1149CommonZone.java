package com.dexing.od1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  给定一组闭区间，其中部分区间存在交集。 
 *  任意两个给定区间的交集，称为公共区间(如:[1,2],[2,3]的公共区间为[2,2]，[3,5],[3,6]的公共区间为[3,5])。 
 *  公共区间之间若存在交集，则需要合并(如:[1,3],[3,5]区间存在交集[3,3]，需合并为[1,5])。 
 *  按升序排列输出合并后的区间列表。 
 *  输入描述 
 *  一组区间列表，区间数为 N: 0<=N<=1000;区间元素为 X: -10000<=X<=10000。
 *  输出描述 
 *  升序排列的合并区间列表 
 *  备注: 
 *  1、区间元素均为数字，不考虑字母、符号等异常输入。 
 *  2、单个区间认定为无公共区间。 
 *  示例1 &nbsp;输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  [[0, 3], [1, 3], [3, 5], [3, 6]] 
 *  输出 
 *  [[1, 5]] 
 *  说明 
 *  [0,3]和[1,3]的公共区间为[1,3]，
 *  [0,3]和[3,5]的公共区间为[3,3]，
 *  [0,3]和[3,6]的公共区间为[3,3]，
 *  [1,3]和[3,5]的公共区间为[3,3]，
 *  [1,3]和[3,6]的公共区间为[3,3]，
 *  [3,5]和[3,6]的公共区间为[3,5]，
 *  公共区间列表为[[1,3],[3,3],[3,5]]；
 *  [1,3],[3,3],[3,5]存在交集，须合并为[1,5]。
 *  示例2 (简化输入版本) 
 *  输入
 *  1 6 2 5 5 7
 *  输出
 *  2 6
 *  说明 [1,6]、[2,5]的交集为[2,5]，[1,6]、[5,7]的交集为[5,6] [2,5]、[5,7]的交集为[5,5] 最后的输出为：2 6
 *  示例3
 *  输入
 *  1 2 3 4
 *  输出
 *  None (这里没看到题目上具体要求输出什么，根据题目情况临场发挥即可)
 */
public class D1149CommonZone {
    public static int min_times;
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 先计算交集
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i += 2) {
            for (int j = i + 2; j < nums.size(); j += 2) {
                int left = Math.max(nums.get(i), nums.get(j));
                int right = Math.min(nums.get(i + 1), nums.get(j + 1));
                if (left <= right) {
                    res.add(new int[]{left, right});
                }
            }
        }
        // 自定义排序
        int[][] res_array = res.toArray(new int[res.size()][]);
        Arrays.sort(res_array, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        // 求交集的并集
        int[][] result = new int[res_array.length][2];
        int index = -1;
        for (int[] single_array : res_array) {
            if (index == -1 || single_array[0] > result[index][1]) {
                result[++index] = single_array;
            } else {
                result[index][1] = Math.max(result[index][1], single_array[1]);
            }
        }
        int[][] last = Arrays.copyOf(result, index + 1);
        for (int i = 0; i < last.length; i++) {
            System.out.print(last[i][0]);
            System.out.print(" ");
            System.out.print(last[i][1]);
            if (i != last.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
