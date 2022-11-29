package com.dexing.od1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给一个无向图染色，可以填红黑两种颜色，必须保证相邻两个节点不能同时为红色，输出有多少种不同的染色方案？
 *  输入描述：
 *  第一行输入M(图中节点数) N(边数)
 *  后续N行格式为：V1 V2表示一个V1到V2的边。
 *  数据范围：1 <= M <= 15,0 <= N <= M * 3，不能保证所有节点都是连通的。
 *  输出描述：
 *  输出一个数字表示染色方案的个数。
 *  示例1：
 *  输入：
 *  4 4
 *  1 2
 *  2 4
 *  3 4
 *  1 3
 *  输出：
 *  7
 *  说明：4个节点，4条边，1号节点和2号节点相连，2号节点和4号节点相连，3号节点和4号节点相连，
 *  1号节点和3号节点相连，若想必须保证相邻两个节点不能同时为红色，总共7种方案。
 */
public class D0303WuNode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split("\\s+");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        // 构造输入数据结构
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s1 = in.nextLine();
            String[] split1 = s1.split("\\s+");
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(Integer.parseInt(split1[0]));
            integers.add(Integer.parseInt(split1[1]));
            list.add(integers);
        }
        int count =0;
        // 遍历所有可能的组合 举例 10001 -> i 的二进制表达式
        for (int i = 0; i < (1 << m); i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                // 检查所有的边相连的是否同为红颜色
                if (((i >> (m - list.get(j).get(0))) & 1) == 1 && ((i >> (m -list.get(j).get(1))) & 1) == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);



        int tem = 1 << 3;
        int i = 3 & 6;

        System.out.println(tem);
    }
}
