package com.dexing.od1;

import java.util.*;
import java.util.stream.Collectors;

public class D1458ErChaShu {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //找到最小子节点
        int idx = dfs(nums, 0);

        //保存这个节点所对应的路径
        List<Integer> path = new ArrayList<>();
        while (idx > 0) {
            path.add(nums.get(idx));
            idx = (idx - 1) / 2;
        }
        path.add(nums.get(0));
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1) {
                System.out.print(path.get(i));
            } else {
                System.out.print(path.get(i) + " ");
            }
        }
    }

    // 返回最小叶子节点在数组中的位置
    private static int dfs(List<Integer> nums, int idx) {
        //超出数组范围或为-1则为叶子节点
        if ((2 * idx + 1 >= nums.size() || nums.get(2 * idx + 1) == -1)
                && (2 * idx + 2 >= nums.size() || nums.get(2 * idx + 2) == -1)) {
            return idx;
        } else {
            int idx_left = dfs(nums, 2 * idx + 1);
            int idx_right = dfs(nums, 2 * idx + 2);
            //比较找最小
            if (idx_left >= nums.size() || nums.get(idx_left) == -1) {
                return idx_right;
            } else if (idx_right >= nums.size() || nums.get(idx_right) == -1) {
                return idx_left;
            } else {
                return nums.get(idx_left) < nums.get(idx_right) ? idx_left : idx_right;
            }
        }
    }
}
