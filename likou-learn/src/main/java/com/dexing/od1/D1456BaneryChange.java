package com.dexing.od1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  某生产门电路的厂商发现某一批次的或门电路不稳定，具体现象为计算两个二进制数的或操作时，
 *  第一个二进制数中某两个比特位会出现交换， 交换的比特位置是随机的，但只交换这两个位，其他位不变。
 *  很明显，这个交换可能会影响最终的或结果，也可能不会有影响。 
 *  为了评估影响和定位出错的根因，工程师需要研究在各种交换的可能下，最终的或结果发生改变的情况有多少种。 
 *  输入描述: 
 *  第一行有一个正整数N;其中1≤N≤1000000。
 *  第二行有一个长为N的二进制数，表示与电路的第一个输入数，即会发生比特交换的输入数。
 *  第三行有一个长为N的二进制数，表示与电路的第二个输入数。注意第二个输入数不会发生比特交换。
 *  输出描述: 
 *  输出只有一个整数，表示会影响或结果的交换方案个数。 
 *  示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入 
 *  3
 *  010
 *  110
 *  输出 
 *  1 
 *  说明 
 *  原本010和110的或结果是110，但第一个输入数可能会发生如下三种交换： 
 *  1.交换第1个比特和第2个比特，第一个输入数变为100，计算结果为110，计算结果不变
 *  2.交换第1个比特和第3个比特，第一个输入数变为010，计算结果为110，计算结果不变
 *  3.交换第2个比特和第3个比特，第一个输入数变为001，计算结果为111，计算结果改变 故只有一种交换会改变计算结果。
 *
 *  思路：
 *  1：明显同数字之间的交换不会产生影响，所以就是0和1之间的交换。 
 *  2：因为要与第二次输入的数进行或计算，那么如果第二次输入的数的其中一位只要是1，那么不管第一次输入有没有发生交换，或结果都是1。
 *  所以第二次输入的当该位为0的时候，第一次输入的交换才有意义
 */
public class D1456BaneryChange {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);

        int n=Integer.parseInt(in.nextLine());
        char[] input_str1 = in.nextLine().toCharArray();
        char[] input_str2 = in.nextLine().toCharArray();

        List<Integer> c = new ArrayList<>();
        int[] cnt = new int[2];
        for (int i=0;i<n;i++) {
            if (input_str2[i] == '0') {
                //System.out.println(input_str1[i]);
                c.add(Integer.parseInt (String.valueOf (input_str1[i])));
            }
            if (input_str1[i] == '0') {
                cnt[0] += 1;
            } else {
                cnt[1] += 1;
            }
        }
        //System.out.println(c);

        int total = 0;

        for (int i=0;i<c.size();i++) {
            total += cnt[c.get(i) ^ 1];
            cnt[c.get(i)] -= 1;
        }

        System.out.println(total);

    }
}
