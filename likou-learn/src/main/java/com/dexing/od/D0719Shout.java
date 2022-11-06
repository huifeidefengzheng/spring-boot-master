package com.dexing.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高3个分数之和进行降序排名，输出降序排名后的选手ID序列。
 *
 * 条件如下：
 *
 * 一个选手可以有多个射击成绩的分数，且次序不固定。
 * 如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手。
 * 如果选手的成绩之和相等，则成绩之和相等的选手按照其ID降序排列。
 * 输入描述:
 *
 * 输入第一行，一个整数N，表示该场比赛总共进行了N次射击，产生N个成绩分数（2<=N<=100）。
 * 输入第二行，一个长度为N整数序列，表示参与每次射击的选手ID（0<=ID<=99）。
 * 输入第三行，一个长度为N整数序列，表示参与每次射击的选手对应的成绩（0<=成绩<=100）。
 * 输出描述:
 * 符合题设条件的降序排名后的选手ID序列。
 *
 * 示例1
 * 输入
 *
 * 13
 * 3,3,7,4,4,4,4,7,7,3,5,5,5
 * 53,80,68,24,39,76,66,16,100,55,53,80,55
 *
 * 输出
 *
 * 5,3,7,4
 * 说明
 *
 * 该场射击比赛进行了13次，参赛的选手为{3,4,5,7}。 3号选手成绩：
 * 53,80,55，最高3个成绩的和为：80+55+53=188。
 * 4号选手成绩：24,39,76,66，最高3个成绩的和为：76+66+39=181。
 * 5号选手成绩：53,80,55，最高3个成绩的和为：80+55+53=188。
 * 7号选手成绩：68,16,100，最高3个成绩的和为：100+68+16=184。
 * 比较各个选手最高3个成绩的和，有3号=5号>7号>4号，由于3号和5号成绩相等且ID号5>3， 所以输出为：5,3,7,4
 */
public class D0719Shout {
    public static void main(String[] args) {
        test();
    }


    public static void test() {
        int num = 13;
        String id = "3,3,7,4,4,4,4,7,7,3,5,5,5";
        String score = "53,80,68,24,39,76,66,16,100,55,53,80,55";
        String[] split = id.split(",");
        String[] split1 = score.split(",");
        HashMap<Integer, List<Integer>> integerListHashMap = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int idNum = Integer.parseInt(split[i]);
            int scorceNum = Integer.parseInt(split1[i]);
            List<Integer> integers3 = integerListHashMap.get(idNum);
            if (integers3 == null) {
                integers3 = new ArrayList<>();
                integers3.add(scorceNum);
            } else {
                integers3.add(scorceNum);
            }
            integerListHashMap.put(idNum,integers3);
        }
        PriorityQueue<int[]> stus = new PriorityQueue<>((v1, v2) -> (
            v1[1] == v2[1] ? v1[0] -v2[0] : v2[1] - v1[1]
        ));
        for (Map.Entry<Integer,List<Integer>> map : integerListHashMap.entrySet()) {
            Integer key = map.getKey();
            List<Integer> value = map.getValue();
            List<Integer> collect = value.stream().sorted((v1, v2) -> v2 - v1).collect(Collectors.toList());
            if (collect.size() >= 3) {
                int coun = collect.get(0) + collect.get(1) +collect.get(2);
                stus.offer(new int[]{key,coun});
            }
        }
        List<int[]> collect = stus.stream().sorted((a, b) -> (a[1] == b[1] ? b[0] - a[0] : b[1] - a[1])).collect(Collectors.toList());
        int size = collect.size();
        for (int i = 0; i < size; i++) {
            if (i == size -1) {
                System.out.print(collect.get(i)[0]);
            } else {
                System.out.print(collect.get(i)[0]+",");

            }
        }

    }
}