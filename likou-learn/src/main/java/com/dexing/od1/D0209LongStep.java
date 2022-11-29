package com.dexing.od1;

import java.util.*;

/**
 * 某探险队负责对地下洞穴进行探险。探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。探索工作结束后，探险队需要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
 * 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中0<x<1000，0<y<1000。同时存在非法坐标，如(01,1)、(1,01)，(0,100)属于非法坐标。
 * 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为：xx+yy。
 * 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 * 若记录仪中的坐标都不合法，输出总部坐标（0,0）。
 * 备注：不需要考虑双层括号嵌套的情况，比如sfsdfsd((1,2))。
 * 输入描述:
 * 字符串，表示记录仪中的数据。
 * 如：ferga13fdsf3(100,200)f2r3rfasf(300,400)
 * 输出描述:
 * 字符串，表示最远足迹到达的坐标。
 * 如： (300,400)
 * 示例1
 * 输入
 * ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
 * 输出
 * (5,10)
 * 说明
 * 记录仪中的合法坐标有3个： (3,10)， (3,4)， (5,10)，其中(5,10)是相距总部最远的坐标， 输出(5,10)。
 * 示例2
 * 输入
 * asfefaweawfaw(0,1)fe
 * 输出
 * (0,0)
 * 说明
 * 记录仪中的坐标都不合法，输出总部坐标（0,0）
 */
public class D0209LongStep {
    public static void main(String[] args) {
        test();
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> list = new ArrayList<>();
        boolean flag = input.contains("(");
        while (flag){
            int i1 = input.indexOf("(");
            int i2 = input.indexOf(")");
            list.add(input.substring(i1+1,i2));
            input = input.substring(i2+1);
            flag = input.contains("(");
        }
        // 分割数据
        int xi = 0 ;
        int yi = 0;
        int maxi = 0;
        for (int i = 0; i < list.size(); i++) {//0<x<1000，0<y<1000
            //数据不能是开头
            String[] split = list.get(i).split(",");
            if (split[0].startsWith("0") || split[1].startsWith("0")){//数据忽略
                continue;
            }
            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            if (x1 <= 0 || x1 >=1000 || y1 <= 0  || y1 >= 1000){
                continue;
            }
            if (x1 * x1 + y1 * y1 > maxi){
                maxi = x1 * x1 + y1 * y1;
                xi = x1;
                yi = y1;
            }
        }
        System.out.println("("+ xi + ","  +yi +")");
    }

    public static void test() {
        String input = "ferga13fdsf3(100,200)f2r3rfasf(300,400)";
        List<List<Integer>> list = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuffer buffer = new StringBuffer();
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int tem = i +1;
            if (c != '(') {
                continue;
            }
            if (c == '(') {
                for (int j = tem; j < input.length(); j++) {
                    char ch = input.charAt(j);
                    if (ch == ')') {
                        i = tem;
                        break;
                    }
                    stack.push(ch);
                }
            }
            ArrayList<Integer> integers = new ArrayList<>();
            while (!stack.isEmpty()) {
                Character pop = stack.pollLast();
                if (pop == ',') {
                    if (check(buffer.toString())) {
                        flag = true;
                    }
                    integers.add(Integer.parseInt(buffer.toString()));
                    buffer = new StringBuffer();
                    continue;
                }
                if (Character.isDigit(pop)) {
                    buffer.append(pop);
                }
            }
            if (buffer.toString() != null) {
                if (check(buffer.toString())) {
                    flag = true;
                }
                integers.add(Integer.parseInt(buffer.toString()));
                list.add(integers);
                buffer = new StringBuffer();
            }
        }
        if(flag) {
            System.out.println("(0,0)");
        } else {
            list.sort((v1,v2) -> (v2.get(0)*v2.get(0) + v2.get(1)*v2.get(1))- (v1.get(0)*v1.get(0) + v1.get(1)*v1.get(1)));
            List<Integer> integers = list.get(0);
            System.out.println("("+integers.get(0)+"," +integers.get(1)+")");
        }
    }

    private static boolean check(String toString) {
        if (toString.startsWith("0")) {
            return true;
        }
        return false;
    }

}
