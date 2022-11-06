package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个正整数数组，检查数组中是否存在满足规则的数字组合
 * 规则：
 * A = B + 2C
 * 输入描述:
 * 第一行输入数组的元素个数。
 * 接下来一行输入所有数组元素，用空格隔开。
 * 输出描述:
 * 如果存在满足要求的数，在同一行里依次输出规则里A/B/C的取值，用空格隔开。
 * 如果不存在，输出0。
 * 示例1：
 * 输入
 * 4
 * 2 7 3 0
 * 输出
 * 7 3 2
 * 说明
 * 7 = 3 + 2 * 2
 * 示例2：
 * 输入
 * 3
 * 1 1 1
 * 输出
 * 0
 * 说明
 * 找不到满足条件的组合
 * 备注:
 * 数组长度在3-100之间。
 * 数组成员为0-65535，数组成员可以重复，但每个成员只能在结果算式中使用一次。如：数组成员为[0, 0, 1, 5]，0出现2次是允许的，但结果0 = 0 + 2 * 0是不允许的，因为算式中使用了3个0。
 * 用例保证每组数字里最多只有一组符合要求的解。
 *
 * 思路：
 *      数组 排序
 */
public class D1650RulrSumArray {
    public static void main(String[] args) {
        test();
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        int[] arr = new int[count];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (checkAdd(arr,i,j)) {
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static boolean checkAdd(int[] arr, int idx1,int idx2) {
        int sub1 = 2 * arr[idx1] + arr[idx2];
        int sub2 = arr[idx1] + 2 * arr[idx2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sub1 && i> idx1 && i> idx2) {
                System.out.println(sub1 + " " + arr[idx2] + " " + arr[idx1]);
                return true;
            }
            if (i> idx1 && i> idx2 && arr[i] == sub2) {
                System.out.println(sub1 + " " + arr[idx1] + " " + arr[idx2]);
                return true;
            }
        }
        return false;
    }

    public static void test() {
        String strArr = "1 1 1";
        String[] split = strArr.split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        boolean isB = false;
        String res = "";
        a: for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            list.remove(integer);
            b: for (int j = 0; j < list.size() -1; j++) {
                Integer integer1 = list.get(j);
                list.remove(integer1);
                int ruleNum = getRuleNum(integer, integer1);
                if (list.contains(ruleNum)) {
                    res = ruleNum +" " + integer + " " + integer1;
                }
                list.add(j,integer1);
            }
            list.add(i,integer);
        }
        if (res.length() > 0) {
            System.out.println(res);
        } else {
            System.out.println(0);
        }
    }

    public static int getRuleNum(int b,int c) {
        return b + 2*c;
    }

}
