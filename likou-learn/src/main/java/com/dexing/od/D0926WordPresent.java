package com.dexing.od;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 公司用一个字符串来表示员工的出勤信息：
 * 
 * absent：缺勤
 * 
 * late：迟到
 * 
 * leaveearly：早退
 * 
 * present：正常上班
 * 
 * 现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下：
 * 
 * 缺勤不超过一次；没有连续的迟到/早退；任意连续7次考勤，缺勤/迟到/早退不超过3次
 * 
 * present
 * 
 * present absent present present leaveearly present absent
 * 
 * 输出描述:
 * 
 * 根据考勤数据字符串，如果能得到考勤奖，输出"true"；否则输出"false"，对于输入示例的结果应为：
 * 
 * true false
 */
public class D0926WordPresent {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
        for (int i = 0; i < 1; i++) {
            String works = "present absent present present leaveearly present absent";
            System.out.print(checkWorks(works));
        }
    }

    private static boolean checkWorks(String works) {
        Stack<String> strings = new Stack<>();
        String[] split = works.split("\\s+");
        int absentNum = 0;
        boolean res = true;
        for (int i = 0; i < split.length; i++) {
            // 缺勤不超过一次
            String cur = split[i];
            if (cur.equals("absent")) {
                absentNum ++;
                if (absentNum >1) {
                    res = false;
                    break;
                }
            }
            if (strings.isEmpty()) {
                strings.push(cur);
                continue;
            } else {
                String peek = strings.peek();
                // 没有连续的迟到/早退
                if ("lateleaveearly".contains(peek) && "lateleaveearly".contains(cur)) {
                    res = false;
                    break;
                }
            }
            // 任意连续7次考勤，缺勤/迟到/早退不超过3次
            if (!checkSeven(i,split)) {
                res = false;
                break;
            }
            strings.push(cur);
        }

        return res;
    }

    private static boolean checkSeven(int i, String[] split) {
        int a = i > 7 ? i - 7 : 0;
        int num = 0;
        for (int j = a; a <= i ; a++) {
            if ("absentlateleaveearly".contains(split[j])) {
                num ++;
            }
        }
        return num > 3 ? false : true;
    }

    public static void test() {

        String str = "present";
        String ss = "present present present leaveearly present present leaveearly present absent";
        String[] split = str.split("\\s+");
        String[] split1 = ss.split("\\s+");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        for (int i = 0; i < split1.length; i++) {
            list.add(split1[i]);
        }
        Stack<String> strings = new Stack<>();
        boolean res = true;
        int absentNum = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            // 不能缺勤超过一次
            if (s.equals("absent")) {
                if (absentNum++ > 1) {
                    res = false;
                    break;
                }
                // 不能连续迟到、早退
            } else if (!strings.isEmpty() && "lateleaveearly".contains(strings.peek()) && "lateleaveearly".contains(s)) {
                res = false;
                break;
                // 任意连续7天 缺勤/迟到/早退 不超过3次
            } else if (i + 1 >= 7) {
                int len = i - 6;
                int coun = 0;
                while (len <= i) {
                    if ("absentlateleaveearly".contains(list.get(len))) {
                        coun++;
                    }
                    len++;
                }
                if (coun > 3) {
                    res = false;
                    break;
                }
                strings.push(s);
            }
        }
        System.out.println(res);
    }
}
