package com.dexing.od;

import java.util.HashMap;

/**
 * 给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出（如果数组长度小于3，则选择数组中所有元素来组成最小数字）。
 * 输入描述:
 * 一行用半角逗号分割的字符串记录的整型数组，0 < 数组长度 <= 100，0 < 整数的取值范围 <= 10000。
 * 输出描述:
 * 由3个元素组成的最小数字，如果数组长度小于3，则选择数组中所有元素来组成最小数字。
 * 示例1
 * 输入
 * 21,30,62,5,31
 * 输出
 * 21305
 * 说明
 * 数组长度超过3，需要选3个元素组成最小数字，21305由21,30,5三个元素组成的数字，为所有组合中最小的数字
 * 示例2
 * 输入
 * 5,21
 * 输出
 * 215
 * 说明
 * 数组长度小于3， 选择所有元素来主城最小值，215为最小值。
 *
 * //思路：
 * //1、大于3各数的数组，从其中选择3各最小的数，组合排序可以得到最小的数
 * //2、小于3各数，组合排序即可
 * //3、可以根据首位进行排序
 */
public class D2373ArrSummin {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String str = "21,30,62,5,31";
        String[] strings = str.split(",");
        StringBuffer buffer = new StringBuffer();
        if (strings.length < 3) {
            for (int i = strings.length -1; i >=0 ; i--) {
                buffer.append(strings[i]);
            }
            System.out.println(buffer);
            return;
        }
        HashMap<Integer, String> map = new HashMap<>();
        int min = Integer.parseInt(strings[0])+Integer.parseInt(strings[1])+Integer.parseInt(strings[2]);
        map.put(min,strings[0]+strings[1]+strings[2]);
        for (int i = 0; i < strings.length; i++) {
            for (int j = i +1; j < strings.length ; j++) {
                for (int k = j +1; k < strings.length; k++) {
                    int i1 = Integer.parseInt(strings[i]) + Integer.parseInt(strings[j]) + Integer.parseInt(strings[k]);
                    if (min > i1) {
                        min = i1;
                        map.put(i1,strings[i]+strings[j]+strings[k]);
                    }
                }
            }
        }
        System.out.println(map.get(min));
    }
}
