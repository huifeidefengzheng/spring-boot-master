package com.dexing.od1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 学校组织活动，将学生排成一个矩形方阵。 请在矩形方阵中找到最大的位置相连的男生数量。 这个相连位置在一个直线上，方向可以是水平的，垂直的，成对角线的或者呈反对角线的。 注：学生个数不会超过10000输入描述
 *  输入的第一行为矩阵的行数和列数，接下来的n行为矩阵元素，元素间用”,”分隔。输出描述
 *  输出一个整数，表示矩阵中最长的位置相连的男生个数。
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  3,4
 *  F,M,M,F
 *  F,M,M,F
 *  F,F,F,M
 *  输出
 *  3
 *  示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  1,2
 *  M,M
 *  输出
 *  2
 *  示例3 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  2,1
 *  M
 *  F
 *  输出
 *  1
 */
public class D731ManMax {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        String[] input_str = in.nextLine().split(",");
        int m = Integer.parseInt(input_str[0]);
        int n = Integer.parseInt(input_str[1]);

        //构造学生矩阵
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] s1 = in.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s1[j];
            }
        }

        //逐个元素判定即可 O(n^2)复杂度
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("M")) {
                    getMaxBoyCount(matrix, i, j, list);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }
    public static void getMaxBoyCount(String[][] matrix, int i, int j, List<Integer> list) {
        int len = 1;
        int a = 0, b = 0;
        int m = matrix.length, n = matrix[0].length;
        if (j < n) {  // 从左往右
            a = i;
            b = j;
            while (b < n - 1 && matrix[a][++b].equals("M")) {
                len++;
            }
            list.add(len);
            len = 1;
        }
        if (i < m) {  // 从上往下
            a = i;
            b = j;
            while (a < m - 1 && matrix[++a][b].equals("M")) {
                len++;
            }
            list.add(len);
            len = 1;
        }
        if (i < m && j < n) {  // 对角线
            a = i;
            b = j;
            while ((a < m - 1 && b < n - 1) && matrix[++a][++b].equals("M")) {
                len++;
            }
            list.add(len);
            len = 1;
        }
        if (i >= 0 && j < n) {  // 对角线从左往右
            a = i;
            b = j;
            while (( a > 0 && b < n - 1) && matrix[--a][++b].equals("M")) {
                len++;
            }
            list.add(len);
        }
    }
}
