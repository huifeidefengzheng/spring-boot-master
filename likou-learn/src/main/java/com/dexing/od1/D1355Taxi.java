package com.dexing.od1;

import java.util.Scanner;

/**
 *  程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。 
 *  出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。 
 *  比如： 
 *  23再多一块钱就变为25； 39再多一块钱变为50； 399再多一块钱变为500； 小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。 
 *  给出计费表的表面读数，返回实际产生的费用。 
 *  输入描述 
 *  只有一行，数字N，表示里程表的读数。 
 *  (1<=N<=888888888)。 
 *  输出描述 
 *  一个数字，表示实际产生的费用。以回车结束。 
 *  示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入 
 *  5 
 *  输出 
 *  4 
 *  说明 
 *  5表示计费表的表面读数。 
 *  4表示实际产生的费用其实只有4块钱。 
 *  示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入 
 *  17 
 *  输出 
 *  15 
 *  说明 
 *  17表示计费表的表面读数。 
 *  15表示实际产生的费用其实只有15块钱。 
 *  示例3  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入 
 *  100 
 *  输出 
 *  81 
 *  说明 
 *  100表示计费表的表面读数。 
 *  81表示实际产生的费用其实只有81块钱。
 */
public class D1355Taxi {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int num = 100;
        int realMoney = 0;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= num; i++) {
            if (String.valueOf(i).contains("4")){
                continue;
            }
            realMoney++;
        }
        long end = System.currentTimeMillis();
        System.out.println(realMoney+"==="+(end-start));
    }

    public static void test2() {
        //处理输入
        Scanner in=new Scanner(System.in);
        int price_after = in.nextInt();
        int ans = price_after;
        long start = System.currentTimeMillis();
        // k 表示当前跳过了多少个4
        // j 表示当前位数
        int skip_money = 0, k = 0, j = 1;
        while (price_after > 0) {
            //当前位上出现了4就 +1 (并考虑当前的位数)
            if (price_after % 10 > 4) {
                skip_money += (price_after % 10 - 1) * k + j;
            } else {
                skip_money += (price_after % 10) * k;
            }
            k = k * 9 + j;
            j *= 10;
            price_after /= 10;
        }
        long end = System.currentTimeMillis();
        System.out.println(ans - skip_money+"==="+(end-start));
    }
}
