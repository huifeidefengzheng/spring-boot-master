package com.dexing.od;

import java.util.Arrays;

/**
 * 叠积木
 * 题目描述
 * 给出一个列表如[[6,7,],[5,4],[3,2]],表示木块的长和宽，当木块的长和宽不大于另个木块的长和宽时，就可以放在上面，此外数组还可以左右翻转。求最多能搭多少层。
 *
 * 输入描述
 * 一个二维数组，里面是每个积木的长和宽，可以左右翻转。
 *
 * 输出描述
 * 最多能搭多少层。
 *
 * 样例
 * 输入
 * [[5,4],[6,3],[6,7],[6,6],[4,6]]
 * 1
 * 输出
 * 4
 *
 *
 */
public class D3199DieJiMu {

    public static void main(String[] args) {
        test();
    }


    public static void test() {
        String s = "[[5,4],[6,3],[6,7],[6,6],[4,6]]".replaceAll("\\[", "");
        s = s.replaceAll("\\]","");
        String[] split = s.split(",");
        int[][] nums= new int[split.length/2][2];
        for (int i = 0; i < nums.length; i++) {
            int i1 = Integer.parseInt(split[2*i]);
            int i2 = Integer.parseInt(split[2*i +1]);
            nums[i][0] = Math.max(i1,i2);
            nums[i][1] = Math.min(i1,i2);
        }
        Arrays.sort(nums,(v1,v2) -> v1[0] == v2[0] ? v2[1]-v1[1]:v2[0]-v1[0]);
        int length = nums.length;
        int ch = nums[0][0],kuan = nums[0][1];
        int res = 1;
        for (int i = 1; i < length; i++) {
            int tch = nums[i][0];
            int tkuan = nums[i][1];
            if (ch >= tch && kuan >= tkuan) {
                ch = tch;
                kuan = tkuan;
                res++;
            }
        }
        System.out.println(res);
    }


}
