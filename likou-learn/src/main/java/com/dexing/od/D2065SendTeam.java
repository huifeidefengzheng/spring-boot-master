package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为N，每个团队可以由1人或2人组成，且1个人只能参加1个团队，请计算出最多可以派出多少支符合要求的团队？
 * 输入描述:
 * 5
 * 3 1 5 7 9
 * 8
 * 第一行数组代表总人数，范围[1,500000]
 * 第二行数组代表每个人的能力，每个元素的取值范围[1, 500000]，数组的大小范围[1,500000]
 * 第三行数值为团队要求的最低能力值，范围[1, 500000]
 * 输出描述:
 * 3
 * 最多可以派出的团队数量
 * 示例1
 * 输入
 * 5
 * 3 1 5 7 9
 * 8
 * 输出
 * 3
 * 说明
 * 3,5组成一队，1,7组成一队，9自己一个队，故输出3
 */
public class D2065SendTeam {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int person = 5;
        String input = "3 1 5 7 2 9";
        int low = 8;
        String[] split = input.split("\\s+");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (i1 >= low) {
                count++;
            } else {
                list.add(i1);
            }
        }
        int start = 0,left = list.size()-1;
        while (start < left ) {
            if (list.get(start) + list.get(left) >= low) {
                count++;
                start ++;
                left --;
            } else if (list.get(start) + list.get(left) < low) {
                start++;
            }
        }
        System.out.println(count);
    }
}
