package com.dexing.od;

import java.util.Scanner;

/**
 * 【最长方连续方波信号】最长方连续方波信号 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 输入一串方波信号，求取最长的完全连续交替方波信号，并将其输出，如果有相同长度的交替方波信号，输出任一即可，方波信号高位用1标识，低位用0标识，如图：
 * 说明：
 * 1） 一个完整的信号一定以0开始然后以0结尾，即010是一个完整信号，但101，1010，0101不是
 * 2）输入的一串方波信号是由一个或多个完整信号组成
 * 3） 两个相邻信号之间可能有0个或多个低位，如0110010，011000010
 * 4） 同一个信号中可以有连续的高位，如01110101011110001010，前14位是一个具有连续高位的信号
 * 5） 完全连续交替方波是指10交替，如01010是完全连续交替方波，0110不是
 * 输入描述: 输入信号字符串（长度>=3且<=1024）： 0010101010110000101000010 注：输入总是合法的，不用考虑异常情况
 * 输出描述: 输出最长的完全连续交替方波信号串： 01010 若不存在完全连续交替方波信号串，输出 -1
 * 示例1
 * 输入
 * 00101010101100001010010
 * 输出
 * 01010
 * 备注:
 * 输入信号串中有三个信号：0 010101010110(第一个信号段) 00 01010(第二个信号段) 010(第三个信号段)
 * 第一个信号虽然有交替的方波信号段，但出现了11部分的连续高位，不算完全连续交替方波，在剩下的连续方波信号串中01010最长
 */
public class D0306FangBoLangest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            int length = str.length();
            String res = null;
            //i小于 size-1，保证后面使用 str[i+1]时不越界
            for (int i = 0; i < length - 1; i++) {
                //第i位是0，第i+1位是1，则表示这是一个信号的开端。
                if (str.charAt(i) == '0' && str.charAt(i + 1) == '1') {
                    String tem = null;
                    //在str中找出以第i位开头的完整信号返回给tmp，并输出信号的结尾所在位置，方便跳过。
                    tem = findCompleteSignal(str, i);
                    i = i + tem.length() + 1;
                    //检查tmp这段完整信号是不是满足“完全连续交替方波信号”，满足则返回true
                    if (check(tem)) {
                        if (res == null) {
                            res = tem;
                        } else {
                            res = res.length() > tem.length() ? res : tem;
                        }
                    }
                    continue;
                }
            }
            //如果res最后还是空字符串，则输出 -1 ；PS：这一段没有的话只能得85%的分数。
            if (res == null) {
                System.out.println(-1);
            } else {
                System.out.println(res);
            }

        }
    }

    private static boolean check(String tem) {
        for (int i = 1; i < tem.length(); i++) {
            if (tem.charAt(i) + tem.charAt(i - 1) - 2 * '0' == 1) {
                continue;
            }
            return false;
        }
        return true;
    }

    // 在str中找出以第i位开头的完整信号返回给tmp，并输出信号的结尾所在位置，方便跳过。
    private static String findCompleteSignal(String str, int i) {
        //在str中找出以第i位开头的完整信号返回给tmp，并输出信号的结尾所在位置，方便跳过。
        int end = i + 1;
        while (end < str.length()) {
            //要求str[end]和 str[end-1]不可以都是0，否则就是波尾了，要退出循环了。
            if (str.charAt(end) + str.charAt(end - 1) - 2 * '0' == 0) {
                break;
            }
            end++;
        }
        //返回tmp这段完整波形的波尾所在位置，方便外面循环跳过。
        return str.substring(i, end);
    }
}
