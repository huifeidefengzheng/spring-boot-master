package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。黑板上已经写上了N个正整数，同学们需要给这每个数分别上一种颜色。为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除。现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。
 * 输入描述:
 * 第一行有一个正整数N，其中1 \leq N \leq 1001≤N≤100。
 * 第二行有N个int型数(保证输入数据在[1,100]范围中)，表示黑板上各个正整数的值。
 * 输出描述:
 * 输出只有一个整数，为最少需要的颜色种数。
 * 示例1
 * 输入
 * 3
 * 2 4 6
 * 输出
 * 1
 * 说明
 * 所有数都能被2整除
 * 示例2
 * 输入
 * 4
 * 2 3 4 9
 * 输出
 * 2
 * 说明
 * 2与4涂一种颜色，4能被2整除；3与9涂另一种颜色，9能被3整除。不能4个数涂同一个颜色，因为3与9不能被2整除。所以最少的颜色是两种。
 */
public class D2269DataColor {
    public static void main(String[] args) {
        test();
    }

    public static void teste2() {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            //如果list的数能整除arr[i] 就过 否则要加进list
            int temp = arr[i];
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);
                if (temp % num == 0){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                list.add(temp);
            }
        }
        System.out.println(list.size());
    }


    public static void test() {
        int n = 3;
        int[] arr = {2, 3, 4, 9,12,19};
        Arrays.sort(arr);
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            check(i1, list);
        }
        System.out.println(list.size());

    }

    private static void check(int i1, ArrayList<List<Integer>> list) {
        if (list.size() == 0) {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(i1);
            list.add(list1);
            return;
        }
        int count =0;
        for (int i = 0; i < list.size(); i++) {
            if (i1 % list.get(i).get(0) == 0) {
                list.get(i).add(i1);
                count--;
                break;
            } else {
                count ++;
            }
        }
        if (count > 0) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(i1);
            list.add(integers);

        }
    }

}
