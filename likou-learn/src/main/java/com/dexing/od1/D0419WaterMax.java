package com.dexing.od1;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D0419WaterMax {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String input = "5 2 9 2 9";
        String[] split = input.split("\\s+");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] =  Integer.parseInt(split[i]);
        }

        int left = 0 , right = arr.length -1 , res = 0;
        while (left < right) {
            res = arr[left] < arr[right] ? Math.max(res,(right - left) * arr[left++]):Math.max(res,(right - left) * arr[right--]);
        }
        System.out.println(res);

    }

}
