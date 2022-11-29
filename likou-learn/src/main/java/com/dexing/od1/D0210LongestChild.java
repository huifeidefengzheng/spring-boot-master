package com.dexing.od1;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 有N个正整数组成的一个序列。给定整数sum，求长度最长的连续子序列，使他们的和等于sum，返回此子序列的长度，如果没有满足要求的序列，返回-1。
 * 输入描述:
 * 序列：1,2,3,4,2
 * sum：6
 * 输出描述:
 * 序列长度：3
 * 输入描述:
 * 序列：1,2,3,4,2
 * sum：6
 * 输出描述:
 * 序列长度：3
 * 示例1
 * 输入
 * 1,2,3,4,2
 * 6
 * 输出
 * 3
 * 说明
 * 解释：1,2,3和4,2两个序列均能满足要求，所以最长的连续序列为1,2,3，因此结果为3
 * 示例2
 * 输入
 * 1,2,3,4,2
 * 20
 * 输出
 * -1
 * 说明
 * 解释：没有满足要求的子序列，返回-1
 * 备注:
 * 输入序列仅由数字和英文逗号构成，数字之间采用英文逗号分隔；
 * 序列长度：1 <= N <= 200；
 * 输入序列不考虑异常情况，由题目保证输入序列满足要求。
 */
public class D0210LongestChild {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String input = "1,2,3,4,2";
        int sum = 6;
        String[] split = input.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int check = check(i, arr, sum);
            index = Math.max(index,check);
        }
        if (index == 0) {
            System.out.println(-1);
        } else {
            System.out.println(index);
        }
    }

    private static int check(int i, int[] arr,int sum) {
        int tem = arr[i] ,left = i+1,index =i +1 ,len=0;
        ArrayList<Integer> list = new ArrayList<>();
        while (left < arr.length) {
            tem+= arr[left];
            list.add(arr[left]);
            if (tem < sum) {
                left++;
            } else if (tem > sum) {
                tem = arr[i];
                left = ++index;
                list.clear();
            } else {
                len = Math.max(list.size() +1,len);
                left = index++;
            }
        }
        return len;
    }
}
