package com.dexing.od;

import java.util.ArrayList;
import java.util.List;


/***
 * 在通信系统中，一个常见的问题是对用户进行不同策略的调度，会得到不同的系统消耗和性能。
 * 假设当前有n个待串行调度用户，每个用户可以使用A/B/C三种不同的调度策略，不同的策略会消耗不同的系统资源。请你根据如下规则进行用户调度，并返回总的消耗资源数。
 * 规则：
 * 1、相邻的用户不能使用相同的调度策略，例如，第1个用户使用了A策略，则第2个用户只能使用B或者C策略。
 * 2、对单个用户而言，不同的调度策略对系统资源的消耗可以归一化后抽象为数值。例如，某用户分别使用A/B/C策略的系统消耗分别为15/8/17。
 * 3、每个用户依次选择当前所能选择的对系统资源消耗最少的策略（局部最优），如果有多个满足要求的策略，选最后一个。
 * 输入描述:
 * 第一行表示用户个数n
 * 接下来每一行表示一个用户分别使用三个策略的系统消耗resA resB resC
 * 输出描述:
 * 最优策略组合下的总的系统资源消耗数
 * 示例1
 * 输入
 * 3
 * 15 8 17
 * 12 20 9
 * 11 7 5
 * 输出
 * 24
 * 说明
 * 1号用户使用B策略，2号用户使用C策略，3号用户使用B策略。系统资源消耗: 8 + 9 + 7 = 24。
 * 备注:
 * 所有策略对系统的资源消耗均为正整数，n < 1000
 */
public class D2884UserCheck {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int num = 3;
        ArrayList<List<Integer>> lists = intData();
        int total = 0;
        int index = -1;
        for (int i = 0; i < 3; i++) {
            List<Integer> list = lists.get(i);
            int min = Integer.MAX_VALUE;
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    Integer integer = list.get(j);
                    if (min >= integer) {
                        min = integer;
                        index = j;
                    }
                }
                total += min;
            } else {
                int tem = 0;
                for (int j = 0; j < 3; j++) {
                    Integer integer = list.get(j);
                    if (j != index && min >= integer) {
                        min = integer;
                        tem = j;
                    }
                }
                index = tem;
                total += min;
            }
        }
        System.out.println(total);
    }

    private static ArrayList<List<Integer>> intData() {
        String[] split = "15 8 17".split("\\s+");
        String[] split1 = "12 20 9".split("\\s+");
        String[] split2 = "11 7 5".split("\\s+");
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        lists.add(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list1.add(Integer.parseInt(split1[i]));
        }
        lists.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list2.add(Integer.parseInt(split2[i]));
        }
        lists.add(list2);
        return lists;
    }
}
