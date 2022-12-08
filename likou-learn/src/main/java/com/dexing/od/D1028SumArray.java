package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个正整数数组，检查数组中是否存在满足规则的数字组合
 * <p>
 * 规则：A = B + 2C
 * <p>
 * 输入描述
 * 第一行输出数组的元素个数。
 * <p>
 * 接下来一行输出所有数组元素，用空格隔开。
 * <p>
 * 输出描述
 * 如果存在满足要求的数，在同一行里依次输出规则里A/B/C的取值，用空格隔开。
 * <p>
 * 如果不存在，输出0。
 * 用例
 * 输入
 * 4
 * 2 7 3 0
 * <p>
 * 输出	7 3 2
 * 说明	7 = 3 + 2 * 2
 * 备注:
 * <p>
 * 数组长度在3-100之间。
 * 数组成员为0-65535，数组成员可以重复，但每个成员只能在结果算式中使用一次。如：数组成员为[0, 0, 1, 5]，0出现2次是允许的，但结果0 = 0 + 2 * 0是不允许的，因为算式中使用了3个0。
 * 用例保证每组数字里最多只有一组符合要求的解。
 */
public class D1028SumArray {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String str = "2 7 3 0";
        List<String> strings = Arrays.asList(str.split("\\s+"));
        String[] split = str.split("\\s+");
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            integers.add(Integer.parseInt(split[i]));
        }
        int size = integers.size();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String C = strings.get(i);
            String replace = str.replace(C, "");
            List<String> strings1 = Arrays.asList(str.replace(C, "").split(" ")).stream().filter(v -> !v.equals("")).collect(Collectors.toList());
            ArrayList<String> check = check(i, Integer.parseInt(C), strings1,replace);
            if (check.size() > 0) {
                list.addAll(check);
            }

        }
        if (list.size() > 0) {
            list.stream().forEach(vo -> System.out.println(vo));
        } else {
            System.out.println(0);
        }
    }

    private static ArrayList<String> check(int i, Integer c, List<String> integers,String replace) {
        int temp = 0;
        ArrayList<String> list = new ArrayList<>();
        while (temp < integers.size()) {
                String B = integers.get(temp);
            String replace1 = replace.replace(B, "");
            int A = getValue(Integer.parseInt(B), c);
                if (replace1.contains(String.valueOf(A))) {
                    list.add(A + " " + B + " " + c);
                }
            temp++;
        }
        return list;
    }

    private static int getValue(int temp, int i) {
        return temp + 2 * i;
    }


}
