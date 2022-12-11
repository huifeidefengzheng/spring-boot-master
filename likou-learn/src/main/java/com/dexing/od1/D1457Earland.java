package com.dexing.od1;

import java.util.Scanner;

/**
 *  题目描述 给你一个由 大于0的数（陆地）和 0（水）组成的的二维网格，请你计算网格中最大岛屿的体积。陆地的数表示所在岛屿的体积。
 *  岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *  此外，你可以假设该网格的四条边均被水包围。
 *  输入描述 第一行是二维网格的宽和高。 后面几行是二维网格。
 *  输出描述 输出岛屿的最大体积。
 *  样例 输入
 *  5 5
 *  0 1 1 0 0
 *  0 1 1 0 0
 *  0 0 0 0 0
 *  0 0 1 2 3
 *  0 0 1 3 9
 *  输出 19
 *
 */
public class D1457Earland {
    public static int area = 0;
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] matrix = new int[row][col];
        int max = Integer.MIN_VALUE;
        //初始化岛屿
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] > 0) {
                    area = 0;
                    //求当前点所属岛屿的大小
                    dfs (matrix, i, j);
                    max = Math.max(area, max);
                }
            }
        }
        System.out.println(max);

    }
    public static void dfs(int[][] matrix, int i, int j) {
        int row = matrix.length, col = matrix[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] == 0) {
            return;
        }
        area += matrix[i][j];
        matrix[i][j] = 0;
        //上下左右判断是否为1
        dfs(matrix, i-1, j);
        dfs(matrix, i+1, j);
        dfs(matrix, i, j-1);
        dfs(matrix, i, j+1);
    }

}
