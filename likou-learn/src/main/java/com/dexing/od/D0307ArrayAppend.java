package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D0307ArrayAppend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int readLen = Integer.parseInt(scanner.nextLine());
        int arrNum = Integer.parseInt(scanner.nextLine());

        /*int readLen = 3;
        int arrNum = 2;
        ArrayList<ArrayList<String>> strings = setStr();
        */

        ArrayList<ArrayList<String>> strings = new ArrayList<>();
        // 接收数据
        int totalLen = 0;
        for (int a = 0; a < arrNum; a++) {
            String[] split = scanner.nextLine().split(",");
            totalLen += split.length;
            ArrayList<String> list = new ArrayList<>(Arrays.asList(split));
            strings.add(list);
        }
        ArrayList<String> rest = new ArrayList<>();
        // 处理数据
        while (rest.size() != totalLen) {
            for (ArrayList<String> list : strings) {
                if (list.size() == 0) {
                    continue;
                }
                int size = list.size();
                int temp = Math.min(readLen, size);
                while (temp > 0) {
                    rest.add(list.remove(0));
                    temp--;
                }
            }
        }


        String collect = rest.stream().collect(Collectors.joining(","));
        System.out.println(collect);

    }

    private static ArrayList<ArrayList<String>> setStr() {
        String[] split = "2,5,6,7,9,5,7".split(",");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(split));
        String[] split1 = "1,7,4,3,4".split(",");
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(split1));
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        res.add(list);
        res.add(list2);
        return res;
    }
}
