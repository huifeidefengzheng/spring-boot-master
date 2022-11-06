package com.dexing.od;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 【找最小数】给一个正整数NUM1，计算出新正整数NUM2，NUM2为NUM1中移除N位数字后的结果，需要使得NUM2的值最小。 输入描述：
 * 1.输入的第一行为一个字符串，字符串由0-9字符组成，记录正整数NUM1，NUM1长度小于32。
 * 2.输入的第二行为需要移除的数字的个数，小于NUM1长度。
 * 如：
 * 2615371
 * 4
 * 输出描述：
 * 输出一个数字字符串，记录最小值NUM2。
 * 如：131
 */
public class D0514FindMinNum {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        int input[] = {2, 6, 1, 5, 3, 7, 1};
        List<Integer> list = new LinkedList<>();
        int k = 4;
        for (int i = 0; i < input.length; i++) {
            while (!list.isEmpty() && k > 0 && ((LinkedList<Integer>) list).getLast() > input[i]) {
                ((LinkedList<Integer>) list).removeLast();
                k--;
            }
            ((LinkedList<Integer>) list).addLast(input[i]);
        }
        for (int i = 0; i < k; i++) {
            ((LinkedList<Integer>) list).removeLast();
        }
        boolean iszero = true;
        StringBuffer sb = new StringBuffer();
        while (!list.isEmpty()) {
            String now = String.valueOf(((LinkedList<Integer>) list).removeFirst());
            if (iszero && now.equals("0")) {
                continue;
            }
            iszero = false;
            sb.append(now);
        }
        if (sb.length() == 0) {
            System.out.print(0);
        } else {
            System.out.print(sb.toString());
        }

    }
}
