package com.dexing.od1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金，现在请你设计一个程序帮助小明计算尽可能花费的最大资金数额。
 * 输入描述:
 * 输入第一行为一维整型数组M，数组长度小于100，数组元素记录单个商品的价格，单个商品价格小于1000。
 * 输入第二行为购买资金的额度R，R小于100000。
 * 输出描述:
 * 输出为满足上述条件的最大花费额度。
 * 注意：如果不存在满足上述条件的商品，请返回-1。
 * 示例1
 * 输入
 * 23,26,36,27
 * 78
 * 输出
 * 76
 * 说明
 * 金额23、26和27相加得到76，而且最接近且小于输入金额78
 * 示例2
 * 输入
 * 23,30,40
 * 26
 * 输出
 * -1
 * 说明
 * 因为输入的商品，无法组合出来满足三件之和小于26.故返回-1
 * 备注:
 * 输入格式是正确的，无需考虑格式错误的情况。
 *
 */
public class D0106HuaFeiJInE {
    public static void main(String[] args) {
        test();
    }
    public static void test2() {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int max = Integer.parseInt(sc.nextLine());
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int total = -1;
        for (int i = 0; i < split.length; i++) {
            for (int j = i+1; j < split.length; j++) {
                for (int k = j+1; k < split.length; k++) {
                    int tem = arr[i] + arr[j] + arr[k];
                    if (tem <= max){
                        total = Math.max(tem,total);
                    }
                }
            }
        }
        System.out.println(total);
    }
    public static void test() {
        String[] split = "23,30,40".split(",");
        int r = 78;
        if (split.length<3) {
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                Integer integer1 = list.get(j);
                for (int k = j+1; k < list.size() ; k++) {
                    Integer integer2 = list.get(k);
                    check(arrayList,integer,integer1,integer2,r);
                }
            }
        }
        if (arrayList.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(list);
            System.out.println(list.get(list.size()-1));
        }
    }

    private static void check(ArrayList<Integer> arrayList, Integer integer, Integer integer1, Integer integer2, int r) {
        int i = integer + integer1 + integer2;
        if (i <= r) {
            arrayList.add(i);
        }
    }
}
