package com.dexing.niuke;

public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int min = Math.min(4, 4);
        System.out.println(min);
    }

    public int minNumberInRotateArray(int[] array) {
        int length = array.length;
        int tmp = array[0];
        if (length == 1) {
            return tmp;
        }
        int left = 1;
        while (left < length) {
            tmp = Math.min(array[left], tmp);
            left++;
        }
        return tmp;
    }

    /**
     * 排序数组的查找问题首先考虑使用 二分法 解决，其可将 遍历法 的 线性级别 时间复杂度降低至 对数级别
     * 算法流程：
     * 1、初始化： 声明 i, j 双指针分别指向 array 数组左右两端
     * 2、循环二分： 设 m = (i + j) / 2 为每次二分的中点（ "/" 代表向下取整除法，因此恒有 i≤m1、当 array[m] > array[j] 时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m + 1, j] 闭区间内，因此执行 i = m + 1
     * 2、当 array[m] < array[j] 时： m 一定在 右排序数组 中，即旋转点 x 一定在[i, m]闭区间内，因此执行 j = m
     * 3、当 array[m] = array[j] 时： 无法判断 mm 在哪个排序数组中，即无法判断旋转点 x 在 [i, m] 还是 [m + 1, j] 区间中。解决方案： 执行 j = j - 1 缩小判断范围
     * 3、返回值： 当 i = j 时跳出二分循环，并返回 旋转点的值 array[i] 即可。
     */
    public int minNumberInRotateArray2(int [] array) {
        // 特殊情况判断
        if (array.length== 0) {
            return 0;
        }
        // 左右指针i j
        int i = 0, j = array.length - 1;
        // 循环
        while (i < j) {
            // 找到数组的中点 m
            int m = (i + j) / 2;
            // m在左排序数组中，旋转点在 [m+1, j] 中
            if (array[m] > array[j]) i = m + 1;
                // m 在右排序数组中，旋转点在 [i, m]中
            else if (array[m] < array[j]) j = m;
                // 缩小范围继续判断
            else j--;
        }
        // 返回旋转点
        return array[i];
    }
}
