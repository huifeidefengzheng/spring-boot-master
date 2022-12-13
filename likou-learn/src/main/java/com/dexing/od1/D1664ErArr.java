package com.dexing.od1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 *  给定两个数组a，b，若a[i] == b[j] 则称 [i, j] 为一个二元组，求在给定的两个数组中，二元组的个数。 
 *  输入描述：
 *  第一行输入 m
 *  第二行输入m个数，表示第一个数组
 *  第三行输入 n
 *  第四行输入n个数，表示第二个数组
 *  输出描述： 
 *  二元组个数。 
 *  示例1： 
 *  输入： 
 *  4 
 *  1 2 3 4 
 *  1 
 *  1 
 *  输出： 
 *  1 
 *  说明：二元组个数为 1个 
 *  示例2： 
 *  输入： 
 *  4 1 1 2 2 4 5 
 *  3 
 *  2 2 4 
 *  输出： 
 *  4 
 *  说明：二元组个数为 5 个
 */
public class D1664ErArr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] s = scanner.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            int anInt = Integer.parseInt(s[i]);
            Integer integer = map.getOrDefault(anInt, 0);
            map.put(anInt,integer+1);
        }
        int n = Integer.parseInt(scanner.nextLine());
        String[] s1 = scanner.nextLine().split(" ");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int anInt = Integer.parseInt(s1[i]);
            Integer integer = hashMap.getOrDefault(anInt, 0);
            hashMap.put(anInt,integer+1);
        }
        int nums = 0;
        for (Map.Entry<Integer,Integer> ma : map.entrySet()) {
            Integer key = ma.getKey();
            Integer value = ma.getValue();
            if (hashMap.containsKey(key)) {
                nums += hashMap.get(key) * value;
            }
        }
        System.out.println(nums);
    }

}
