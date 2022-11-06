package com.dexing.od;

import java.util.Scanner;

/**
 * 喊7是一个传统的聚会游戏，N个人围成一圈，按顺时针从1到N编号。编号为1的人从1开始喊数，下一个人喊的数字为上一个人的数字加1，
 * 但是当将要喊出来的数字是7的倍数或者数字本身含有7的话，不能把这个数字直接喊出来，而是要喊"过"。
 * 假定玩这个游戏的N个人都没有失误地在正确的时机喊了"过"，当喊到数字K时，可以统计每个人喊"过"的次数。
 * 现给定一个长度为N的数组，存储了打乱顺序的每个人喊"过"的次数，请把它还原成正确的顺序，即数组的第i个元素存储编号i的人喊"过"的次数。
 * 输入描述:
 * 输入为一行，为空格分隔的喊"过"的次数，注意K并不提供，K不超过200，而数字的个数即为N。
 * 输出描述:
 * 输出为一行，为顺序正确的喊"过"的次数，也由空格分隔。
 * 示例1：
 * 输入
 * 0 1 0
 * 输出
 * 1 0 0
 * 说明
 * 一共只有一次喊"过"，那只会发生在需要喊7时，按顺序，编号为1的人会遇到7，故输出1 0 0。注意，结束时的K不一定是7，也可以是8、9等，喊过的次数都是1 0 0。
 * 示例2：
 * 输入
 * 0 0 0 2 1
 * 输出
 * 0 2 0 1 0
 * 说明
 * 一共有三次喊"过"，发生在7 14 17，按顺序，编号为2的人会遇到7 17，编号为4的人会遇到14，故输出0 2 0 1 0。
 *
 * 思路：
 *      先算出一个逢7过了多少次total；初始化数组arr[input.length+1],不要数字的0位；
 *      由于当喊到数字K时，K不超过200，遍历K，判断当前数字是否包含7或者7的倍数，
 *      将当前人在数组的位置为i%input.length，并将数组位置+1==arr[i%input.length]++，
 *      并统计过的次数temp，在判断temp与total的大小，如果temp>=total结束循环；
 */
public class D1544SevenNum {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
//        Scanner sc = new Scanner(System.in);
        String[] input = "0 0 0 2 1".split(" ");
        int[] arr = new int[input.length+1];
        int total = 0;
        for (int i = 0; i < input.length; i++) {
            total += Integer.parseInt(input[i]);
        }
        int temp = 0;
        for (int i = 1; i < 200; i++) {
            if (checkSeven(i)){
                arr[i% input.length]++;
                temp++;
            }
            if (temp>= total){
                break;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        //7 14 17 21 27 28
    }

    private static boolean checkSeven(int num){
        //1、是不是7的倍数
        if (num % 7 == 0 || String.valueOf(num).contains("7")){
            return true;
        }
        //2、是不是数字包含7 -> 拆解所有位

       /* while (num > 0){
            int wi = num % 10;
            if (wi == 7){
                return true;
            }
            num /= 10;
        }*/
        return false;
    }
}
