package com.dexing.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 【整数对最小和】给定两个整数数组array1、array2，数组元素按升序排列。假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值。
 * 注意：两对元素如果对应于array1、array2中两个下标均相同，则视为同一对元素。
 * <p>
 * 输入描述
 * 输入两行数组array1、array2，每行首个数字为数组大小size(0<size<=100)
 * 0<array1[i]<=1000
 * 0<array2[i]<=1000
 * 接下来一行为正整数k
 * 0<k<=array1.size()*array2.size()
 * <p>
 * 输出描述
 * 满足要求的最小和
 * <p>
 * 示例1
 * <p>
 * 输入
 * 3 1 1 2
 * 3 1 2 3
 * 2
 * 输出
 * 4
 */
public class D0205KArrayListMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = getArr(scanner.nextLine());
        int[] arr2 = getArr(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList<>();


        for (int a1 : arr1) {
            for (int a2 : arr2) {
                list.add(a1 + a2);
            }
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + collect.get(i);
        }
        System.out.println(sum);
        scanner.close();

    }

    private static int[] getArr(String nextLine) {
        String[] split = nextLine.split("\\s+");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        return ints;
    }


}
