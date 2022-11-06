package com.dexing.od;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 如果3个正整数(a,b,c)满足a2 + b2 = c2的关系，则称(a,b,c)为勾股数（著名的勾三股四弦五），
 * 为了探索勾股数的规律，我们定义如果勾股数(a,b,c)之间两两互质（即a与b，a与c，b与c之间均互质，没有公约数），则其为勾股数元祖
 * （例如(3,4,5)是勾股数元祖，(6,8,10)则不是勾股数元祖）。请求出给定范围[N,M]内，所有的勾股数元祖。
 * 输入描述:
 * 起始范围N，1 <= N <= 10000
 * 结束范围M，N < M <= 10000
 * 输出描述:
 * a,b,c请保证a < b < c,输出格式：a b c；
 * 多组勾股数元祖请按照a升序，b升序，最后c升序的方式排序输出；
 * 给定范围中如果找不到勾股数元祖时，输出”NA”。
 * 示例1：
 * 输入
 * 1
 * 20
 * 输出
 * 3 4 5
 * 5 12 13
 * 8 15 17
 * 说明
 * [1, 20]范围内勾股数有：(3 4 5)，(5 12 13)，(6 8 10)，(8 15 17)，(9 12 15)，(12 16 20)；其中，满足(a,b,c)之间两两互质的勾股数元祖有：(3 4 5)，(5 12 13)，(8 15 17)；按输出描述中顺序要求输出结果。
 * 示例2：
 * 输入
 * 5
 * 10
 * 输出
 * NA
 * 说明
 * [5, 10]范围内勾股数有：(6 8 10)；其中，没有满足(a,b,c)之间两两互质的勾股数元祖； 给定范围中找不到勾股数元祖，输出”NA”。
 *
 *
 */
public class D0516GouGuNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        List<int[]> res = solution(start,end);
        if (res.size() == 0) {
            System.out.println("Na");
        }
        for (int i = 0; i < res.size(); i++) {
            int[] ints = res.get(i);
            System.out.println(ints[0] + " " +ints[1] + " " +ints[2]);
        }
    }

    private static List<int[]> solution(int start, int end) {
        ArrayList<int[]> ints = new ArrayList<>();

        for (int i = start; i <= end-2 ; i++) {
            for (int j = start; j < end -1; j++) {
                double sqrt = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
                int c = (int) sqrt;
                long cz = (long) sqrt;
                if (sqrt -cz == 0 &&  c <= end  &&  c >j &&  j > i && isPrim(i,j) && isPrim(i,c) && isPrim(j,c)){
                    int[] ints1 = {i, j, c};
                    ints.add(ints1);
                } else if (c > end ){
                    break;
                }
            }
        }
        return ints;
    }

    public static boolean isPrim(int a,int b) {
        if (a < b) {
            int tem = a;
            a = b;
            b = tem;
        }

        int c;
        while ((c = a % b) !=0) {
           a = b;
           b = c;
        }
        return b == 1;
    }


    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int i1 = sc.nextInt();//[1,10000]
        int i2 = sc.nextInt();//[n,10000]
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = i1; i <= i2 ; i++) {
            for (int j = i+1; j <= i2 ; j++) {
                if (checkFlag(i,j,i2)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    list.add((int)Math.sqrt(i*i + j*j));
                    Collections.sort(list);
                    lists.add(list);
                }
            }
        }
        //所有的勾股数都在lists里,逐个排除存在公约数的数组
        int idx = 0;
        while (idx < lists.size()){
            List<Integer> list = lists.get(idx);
            if (checkYue(list.get(0),list.get(1),list.get(2))) {
                lists.remove(idx);
                idx = 0;
            }
            idx++;
        }
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            System.out.println(list.get(0) + " " + list.get(1) + " "+ list.get(2));
        }
    }
    private static boolean checkFlag(int a1,int a2,int max){
        int mul = a1 *a1 + a2 * a2;
        double res = Math.sqrt(mul);
        int sub = (int) res;
        return res * res  == sub * sub && sub<= max && sub>a2;
    }

    //369 246
    private static boolean checkYue(int a1,int a2,int a3){
        for (int i = 2; i < a3; i++) {
            if (a1 % i ==0 && a2 % i == 0){
                return true;
            }else if (a1 % i == 0 && a3 % i == 0){
                return true;
            }else if (a2 % i == 0 && a3 % i == 0){
                return true;
            }
        }
        return false;
    }
}
