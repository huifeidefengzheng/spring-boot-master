package com.dexing.od1;

import java.util.ArrayList;
import java.util.Scanner;

import static sun.nio.ch.IOStatus.check;

/**
 *  所谓水仙花数，是指一个n位的正整数，其各位数字的n次方和等于该数本身。
 *  例如153是水仙花数，153是一个3位数，并且153 = 1^3 + 5^3 + 3^3。 
 *  输入描述 
 *  第一行输入一个整数n，表示一个n位的正整数。n在3到7之间，包含3和7。 
 *  第二行输入一个正整数m，表示需要返回第m个水仙花数。 
 *  输出描述 
 *  返回长度是n的第m个水仙花数。个数从0开始编号。 
 *  若m大于水仙花数的个数，返回最后一个水仙花数和m的乘积。 
 *  若输入不合法，返回-1。 
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  3
 *  0
 *  输出 
 *  153 
 *  说明 
 *  153是第一个水仙花数 
 *  示例2 输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  9 
 *  1 
 *  输出 
 *  -1 
 *  说明 
 *  9超出范围
 */
public class D1253WaterNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        if (n < 3 || n >7) {
            System.out.println(-1);
            return;
        }
        double v = Math.pow(10, n) - 1;
        int start = (int)Math.pow(10,n-1);
        int v1 = (int) v;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i <= v1; i++) {
            if (checki(i)) {
                list.add(i);
                System.out.println(i);
            }
        }
        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(m));
        }
    }

    private static boolean checki(int i) {
        int tem = i;
        String s = String.valueOf(i);
        int sum = 0;
        while (tem != 0){
            sum+= Math.pow(tem%10,s.length());
            tem = tem/10;
        }
        return sum == i ? true:false;
    }
}
