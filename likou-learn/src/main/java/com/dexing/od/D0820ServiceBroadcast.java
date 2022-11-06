package com.dexing.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 服务器广播
 * 题目描述：
 * 服务器连接方式包括直接相连，间接连接。A 和 B 直接连接，B 和 C 直接连接，则 A 和 C 间接连接。直接连接和间接连接都可以发送广播。
 *
 * 给出一个 N*N 数组，代表 N 个服务器，matrix[i][j]==1，则代表 i 和 j 直接连接；
 * 不等于 1 时，代表 i 和 j 不直接连接。
 * matrix[i][i]==1，即自己和自己直接连接。matrix[i][j]==matrix[j][i]。
 * 计算初始需要给几台服务器广播，才可以使每个服务器都收到广播。
 *
 * 输入描述
 * 输入为N行，每行有N个数字，为0或1，由空格分隔，构成N*N的数组，N的范围为 1<=N<=50
 *
 * 输出描述
 * 输出一个数字，为需要广播的服务器数量
 *
 * 示例 1：
 * 输入
 * 1 0 0
 * 0 1 0
 * 0 0 1
 * 输出
 * 3
 * 说明
 * 3台服务器互不连接，所以需要分别广播这3台服务器
 *
 * 示例 1：
 * 输入
 * 1 1
 * 1 1
 * 输出
 * 1
 * 说明
 * 2台服务器相互连接，所以只需要广播其中一台服务器
 *
 * 思路分析：
 * 从第一个开始判断，依次将直连的服务器加进来
 * 从1找到的集合中依次将直连的服务器加进来，直到集合没有变化
 * 获取1集合中不存在的服务器，重复以上步骤
 * 上述集合的个数，就是需要发出广播的服务器数量
 */
public class D0820ServiceBroadcast {
    public static void main(String[] args) {

    }

    public static void test() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] str = in.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {  // 把第一行加入list
                list.add(Integer.parseInt(str[i]));
            }
            for (int i = 0; i < str.length - 1; i++) {  // 把剩下的行都加入list
                String[] s = in.nextLine().split(" ");
                for (int j = 0; j < s.length; j++) {
                    list.add(Integer.parseInt(s[j]));
                }
            }
            int N = str.length;
            List<List<Integer>> res = new ArrayList<>(); // 存储需要广播的服务器
            for (int i = 0; i < N; i++) {  // 每一行
                if (isContainer(res, i)) {  // 判断某个服务器是否已经存在其连通的服务器集合中
                    continue;
                }
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                int lastLength = 0;
                while (lastLength != newList.size()) { // 判断当前集合可以联通的服务器
                    for (int k = 0; k < newList.size(); k++) {
                        int x = newList.get(k);
                        for (int j = 0; j < N; j++) {
                            int index = x * (N) + j;  // 找到在对应list的索引
                            if (list.get(index).equals(1)) {
                                if (!newList.contains(j)) {
                                    newList.add(j);
                                }
                            }
                        }
                    }
                    lastLength = newList.size();
                }
                res.add(newList);
            }
            System.out.println(res.size());
        }
    }

    public static Boolean isContainer(List<List<Integer>> res, int x) {
        for (List<Integer> integers : res) {
            if (integers.contains(x)) {
                return true;
            }
        }
        return false;
    }
}
