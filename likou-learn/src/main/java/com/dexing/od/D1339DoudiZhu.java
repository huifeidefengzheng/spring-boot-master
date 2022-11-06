package com.dexing.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在斗地主扑克牌游戏中， 扑克牌由小到大的顺序为：3,4,5,6,7,8,9,10,J,Q,K,A,2，玩家可以出的扑克牌阵型有：单张、对子、顺子、飞机、炸弹等。
 * 其中顺子的出牌规则为：由至少5张由小到大连续递增的扑克牌组成，且不能包含2。
 * 例如：{3,4,5,6,7}、{3,4,5,6,7,8,9,10,J,Q,K,A}都是有效的顺子；而{J,Q,K,A,2}、 {2,3,4,5,6}、{3,4,5,6}、{3,4,5,6,8}等都不是顺子。
 * 给定一个包含13张牌的数组，如果有满足出牌规则的顺子，请输出顺子。
 * 如果存在多个顺子，请每行输出一个顺子，且需要按顺子的第一张牌的大小（必须从小到大）依次输出。
 * 如果没有满足出牌规则的顺子，请输出No。
 * 输入描述:
 * 13张任意顺序的扑克牌，每张扑克牌数字用空格隔开，每张扑克牌的数字都是合法的，并且不包括大小王：
 * 2 9 J 2 3 4 K A 7 9 A 5 6
 * 不需要考虑输入为异常字符的情况
 * 输出描述:
 * 组成的顺子，每张扑克牌数字用空格隔开：
 * 3 4 5 6 7
 * 示例1：
 * 输入
 * 2 9 J 2 3 4 K A 7 9 A 5 6
 * 输出
 * 3 4 5 6 7
 * 说明
 * 13张牌中，可以组成的顺子只有1组：3 4 5 6 7
 * 示例2：
 * 输入
 * 2 9 J 10 3 4 K A 7 Q A 5 6
 * 输出
 * 3 4 5 6 7
 * 9 10 J Q K A
 * 说明
 * 13张牌中，可以组成2组顺子，从小到大分别为：3 4 5 6 7 和 9 10 J Q K A
 * 示例3：
 * 输入
 * 2 9 9 9 3 4 K A 10 Q A 5 6
 * 输出
 * No
 * 说明
 * 13张牌中，无法组成顺子
 */
public class D1339DoudiZhu {
    private static boolean flag = false;
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String[] input = "2 9 J 10 3 4 K A 7 Q A 5 6".split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            String tem = input[i];
            if (tem.equals("A")){
                arr[i] = 14;
            }else if (tem.equals("J")){
                arr[i] = 11;
            }else if (tem.equals("Q")){
                arr[i] = 12;
            }else if (tem.equals("K")){
                arr[i] = 13;
            }else {
                arr[i] = Integer.parseInt(tem);
            }
        }
        Arrays.sort(arr);
        //查找可以连成5张的顺子
        int start = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2){//2不能顺子
                continue;
            }
            if (start == 0){//初始化
                start = arr[i];
                temp = arr[i];
                continue;
            }
            if (arr[i] == temp){//对子等
                continue;
            }
            if (arr[i] == temp+1){
                temp = arr[i];
            }else {//不能连上了
                if (temp - start >= 4){
                    print(start,temp);
                }
                start = 0;
                temp = 0;
            }
        }
        if (temp - start >= 4){
            print(start,temp);
        }
        if (!flag){
            System.out.println("NO");
        }
    }

    private static void print(int start,int end){
        flag = true;
        for (int j = start; j <= end ; j++) {
            if (j == 14){
                System.out.print("A ");
            }else if (j == 11){
                System.out.print("J ");
            }else if (j == 12){
                System.out.print("Q ");
            }else if (j == 13){
                System.out.print("K ");
            }else {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }
}
