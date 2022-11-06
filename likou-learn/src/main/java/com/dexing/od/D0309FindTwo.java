package com.dexing.od;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class D0309FindTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("\\s+");
        int minest = Integer.MAX_VALUE;
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            for (int j = i + 1; j <= split.length - 1; j++) {
                int temp = Integer.parseInt(split[i]) + Integer.parseInt(split[j]);
                if (minest > Math.abs(temp)) {
                    integerStringHashMap.put(Math.abs(temp), split[i] + " " + split[j]);
                }
                minest = Math.min(Math.abs(temp), minest);
            }
        }
        String s = integerStringHashMap.get(minest);
        System.out.println(s + " " + minest);
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" ");
            int length = split.length;
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            // 记录最小绝对值
            int min = Integer.MAX_VALUE;
            int[] minArr = new int[2];
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    int sum = Math.abs(arr[i] + arr[j]);
                    if (sum < min) {
                        min = sum;
                        minArr[0] = arr[i];
                        minArr[1] = arr[j];
                    }
                }
            }
            Arrays.sort(minArr);
            for (int i : minArr) {
                System.out.print(i + " ");
            }
            System.out.println(min);
        }
        sc.close();
    }
}
