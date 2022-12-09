package com.dexing.od1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 模拟商场优惠打折，有三种优惠券可以用，满减券、打折券和无门槛券。
 *  满减券：满100减10，满200减20，满300减30，满400减40，以此类推不限制使用；
 *  打折券：固定折扣92折，且打折之后向下取整，每次购物只能用1次；
 *  无门槛券：一张券减5元，没有使用限制；
 *      每个人结账使用优惠券时有以下限制：每人每次只能用两种优惠券，并且同一种优惠券必须一次用完，不能跟别的穿插使用（比如用一张满减，再用一张打折，再用一张满减，这种顺序不行）。
 *      求不同使用顺序下每个人用完券之后得到的最低价格和对应使用优惠券的总数；如果两种顺序得到的价格一样低，就取使用优惠券数量较少的那个。
 *  输入描述：
 *  第一行三个数字m,n,k，分别表示每个人可以使用的满减券、打折券和无门槛券的数量
 *  第二行一个数字x, 表示有几个人购物
 *  后面x行数字，依次表示是这几个人打折之前的商品总价
 *  输出描述：
 *  输出每个人使用券之后的最低价格和对应使用优惠券的数量
 *  示例：
 *  输入：
 *  3 2 5
 *  3
 *  100
 *  200
 *  400
 *  输出：
 *  65 6
 *  135 8
 *  275 8
 *  说明:
 *  第一个人使用 1 张满减券和5张无门槛券价格最低。
 *  第二个人使用 3 张满减券和5张无门槛券价格最低。
 *  第二个人使用 3 张满减券和5张无门槛券价格最低。
 */
public class D0628Shoping {
    public static void main(String[] args) {
        test();
    }
    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> collect = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int i1 = Integer.parseInt(scanner.nextLine());
        while (scanner.hasNextLine()){
            int cur = Integer.parseInt(scanner.nextLine());
            getMin(collect,cur);
        }
    }

    private static void getMin(List<Integer> collect, int curMoney) {
        int[][] rest = new int[3][2];
        int m = collect.get(0);
        int n = collect.get(1);
        int k = collect.get(2);
        rest[0] = modelmn(curMoney,m,n);
        rest[1] = modlemk(curMoney,m,k);
        rest[2] = modelnk(curMoney,n,k);
        Arrays.sort(rest, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] -o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        System.out.print(rest[0][0]);
        System.out.print(" ");
        System.out.print(rest[0][1]);
        System.out.println();

    }

    public static void test() {
        String[] s = "3 2 5".split(" ");
        int[] zhekou = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            zhekou[i] = Integer.parseInt(s[i]);
        }
        int num = 3;
        int curMoney  = 400;
        int[] res = daZhe(curMoney,zhekou);
        System.out.print(res[0]);
        System.out.print(" ");
        System.out.print(res[1]);
        System.out.println();
    }

    private static int[] daZhe(int curMoney, int[] zhekou) {
        if (curMoney< 100){
            curMoney = (int)(Math.round(Math.floor(curMoney*0.92))) - zhekou[2] *5;

            return new int[]{curMoney,zhekou[2]+1};
        }
        int[][] rest = new int[3][2];
        int m = zhekou[0];
        int n = zhekou[1];
        int k = zhekou[2];
        rest[0] = modelmn(curMoney,m,n);
        rest[1] = modlemk(curMoney,m,k);
        rest[2] = modelnk(curMoney,n,k);
        Arrays.sort(rest, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] -o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        return rest[0];
    }

    private static int[] modelnk(int curMoney, int n, int k) {
        int count = 0;
        int tem = curMoney;
        tem *= 0.92;
        count+=1;
        for (int i = 0; i < k; i++) {
            tem -= 5;
            count++;
            if (tem<0){
                break;
            }
        }
        return new int[]{tem,count};
    }

    private static int[] modlemk(int curMoney, int m, int k) {
        int count = 0;
        int tem = curMoney;
        while (m > 0){
            if (tem < 100) {
                break;
            }
            tem -= (tem/100*10);
            m--;
            count++;
        }
        for (int i = 0; i < k; i++) {
            tem -= 5;
            count++;
            if (tem<0){
                break;
            }
        }
        return new int[]{tem,count};
    }

    private static int[] modelmn(int curMoney, int m, int n) {
        int count = 0;
        int tem = curMoney;
        while (m > 0){
            if (tem < 100) {
                break;
            }
            tem -= (tem/100*10);
            m--;
            count++;
        }
        tem *= 0.92;
        count+=1;
        return new int[]{tem,count};

    }
}
