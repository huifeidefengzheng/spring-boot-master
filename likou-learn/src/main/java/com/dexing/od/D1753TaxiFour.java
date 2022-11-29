package com.dexing.od;

import java.util.Scanner;

/**
 *程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
 * 出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。
 * 比如：
 * 23再多一块钱就变为25；
 * 39再多一块钱变为50；
 * 399再多一块钱变为500；
 * 小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。
 * 给出计费表的表面读数，返回实际产生的费用。
 * 输入描述:
 * 只有一行，数字N，表示里程表的读数。
 * (1<=N<=888888888)。
 * 输出描述:
 * 一个数字，表示实际产生的费用。以回车结束。
 * 示例1：
 * 输入
 * 5
 * 输出
 * 4
 * 说明
 * 5表示计费表的表面读数。
 * 4表示实际产生的费用其实只有4块钱。
 * 示例2：
 * 输入
 * 17
 * 输出
 * 15
 * 说明
 * 17表示计费表的表面读数。
 * 15表示实际产生的费用其实只有15块钱。
 * 示例3：
 * 输入
 * 100
 * 输出
 * 81
 * 说明
 * 100表示计费表的表面读数。
 * 81表示实际产生的费用其实只有81块钱。
 */
public class D1753TaxiFour {
    public static void main(String[] args) {
        System.out.println(4%4);
        test();
    }

    public static void test() {
        int input = 100;
        int res = 0;
        for (int i = 1; i <= input; i++) {
            String s = String.valueOf(i);
            if (s.contains("4")) {
                continue;
            }
            res ++;
        }
        System.out.println(res);
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int reduce = 0;
        int idx = 0;
        while (idx < input){
            int next = idx +1 ;
            String temp = String.valueOf(next);
            String newTemp = "";
            if (temp.contains("4")) {
                int fourIdx = temp.indexOf("4");
                if (fourIdx == temp.length()-1){
                    newTemp = temp.substring(0,fourIdx) + 5;
                }else {
                    newTemp = temp.substring(0,fourIdx) + 5 + temp.substring(fourIdx+1);
                }
                reduce += Integer.parseInt(newTemp) - idx -1;
                idx = Integer.parseInt(newTemp);
            }else {
                idx++;
            }
        }
        System.out.println(input - reduce);
    }

}
