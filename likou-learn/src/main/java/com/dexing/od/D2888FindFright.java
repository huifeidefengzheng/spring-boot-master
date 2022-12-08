package com.dexing.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 在学校中，N个小朋友站成一队， 第i个小朋友的身高为height[i]，
 * 第i个小朋友可以看到的第一个比自己身高更高的小朋友j，那么j是i的好朋友(要求j > i)。
 * 请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替。
 * 小朋友人数范围是 [0, 40000]。
 * 输入描述:
 * 第一行输入N，N表示有N个小朋友
 * 第二行输入N个小朋友的身高height[i]，都是整数
 * 输出描述:
 * 输出N个小朋友的好朋友的位置
 * 示例1
 * 输入
 * 2
 * 100 95
 * 输出
 * 0 0
 * 说明
 * 第一个小朋友身高100，站在队尾位置，向队首看，没有比他身高高的小朋友，所以输出第一个值为0。
 * 第二个小朋友站在队首，前面也没有比他身高高的小朋友，所以输出第二个值为0。
 * 示例2
 * 输入
 * 8
 * 123 124 125 121 119 122 126 123
 * 输出
 * 1 2 6 5 5 6 0 0
 * 说明
 * 123的好朋友是1位置上的124
 * 124的好朋友是2位置上的125
 * 125的好朋友是6位置上的126
 * 以此类推
 */
public class D2888FindFright {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int num = 8;
        String[] split = "123 124 125 121 119 122 126 123".split("\\s+");
        int[] ints = new int[num];
        int tem = Integer.parseInt(split[0]);
        for (int i = 1; i < num; i++) {
            int te = i;
            while (te < num ) {
                if (Integer.parseInt(split[te]) > tem ){
                    ints[i-1] = te;
                    tem = Integer.parseInt(split[i]);
                    break;
                }
                te++;
            }
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
        System.out.println();
    }
    public static void test2() {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String height_str = in.nextLine();
        String[] heights =height_str.split(" ");

        //单调栈
        List<Integer> list = new ArrayList<>();
        for (int i =0;i<N;i++){
            int height1 = Integer.parseInt(heights[i]);
            int index=0;
            for (int j =i;j<N;j++){
                int height2 = Integer.parseInt(heights[j]);
                if (height2>height1){
                    index=j;
                    break;
                }
            }
            list.add(index);
        }

        //输出
        StringBuilder sb =new StringBuilder();
        for (int i : list){
            sb.append(i).append(" ");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}
