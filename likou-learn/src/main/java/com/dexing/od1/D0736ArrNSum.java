package com.dexing.od1;

import java.util.*;
import java.util.stream.Collectors;


/**
 *  给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。 
 *  说明： 
 *  数组中数字范围[0, 1000]
 *  最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1 输入非法返回-1
 *  输入描述:
 *  第一行输入M， M标识数组大小
 *  第二行输入M个数，标识数组内容
 *  第三行输入N，N表达需要计算的最大、最小N个数 输出描述:
 *  输出最大N个数与最小N个数的和。
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入 
 *  5 
 *  95 88 83 64 100 
 *  2 
 *  输出 
 *  342 
 *  说明 
 *  最大2个数[100,95],最小2个数[83,64], 输出为342。 
 *  示例2 输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  5 
 *  3 2 3 4 2 
 *  2 
 *  输出 
 *  -1 
 *  说明 
 *  最大2个数[4,3],最小2个数[3,2], 有重叠输出为-1。
 */
public class D0736ArrNSum {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
        int m = 5;
        String[] s = "95 88 83 64 100".split(" ");
//        int n = Integer.parseInt(scanner.nextLine());
        int n = 2;
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            integers.add(Integer.parseInt(s[i]));
        }
        ArrayList<Integer> list = new ArrayList<>(integers);
        Collections.sort(list);
        if (2*n > list.size()) {
            System.out.println(-1);
            return;
        }
        List<Integer> list1 = list.subList(0, n);
        List<Integer> list2 = list.subList(list.size() - n, integers.size());
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += list1.get(i)+list2.get(i);
        }
        System.out.println(res);

    }
}
