package com.dexing.od;

import java.util.Scanner;

/**
 * 存在一个mn的二维数组，其成员取值范围为0或1。其中值为1的成员具备扩散性，每经过1S，将上下左右值为0的成员同化为1。二维数组的成员初始值都为0，将第[i,j]和[k,l]两个个位置上元素修改成1后，求矩阵的所有元素变为1需要多长时间。
 * 输入描述:
 * 输出数据中的前2个数字表示这是一个mn的矩阵，m和n不会超过1024大小；中间两个数字表示一个初始扩散点位置为i,j；最后2个数字表示另一个扩散点位置为k,l。
 * 输出描述:
 * 输出矩阵的所有元素变为1所需要秒数。
 * 示例1：
 * 输入
 * 4,4,0,0,3,3
 * 输出
 * 3
 * 说明
 * 输出数据中的前2个数字表示这是一个4*4的矩阵；中间两个数字表示一个初始扩散点位置为0,0；最后2个数字表示另一个扩散点位置为3,3。
 * 给出的样例是一个很简单模型，初始点在对角线上，达到中间的位置分别为3次迭代，即3秒。所以输出为3。
 *
 * 思路：
 *      先判断二维数组中是否还有0，如果存在进行扩散，
 */
public class D1651Juzhen {
    private static int m1;
    private static int n1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        m1 = Integer.parseInt(split[0]);
        n1 = Integer.parseInt(split[1]);
        int[][] arr = new int[m1][n1];
        int x1 = Integer.parseInt(split[2]);
        int y1 = Integer.parseInt(split[3]);
        int x2 = Integer.parseInt(split[4]);
        int y2 = Integer.parseInt(split[5]);
        arr[x1][y1] = 1;
        arr[x2][y2] = 1;
        System.out.println(calcSecond(arr));
    }
    private static int calcSecond(int[][] arr){
        int used = 0;
        while (checkHasZero(arr)){
            int[][] arrTemp = new int[m1][n1];
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    if (arr[i][j] == 1) {
                        arrTemp[i][j] = 1;
                        //上下左右
                        if (i-1 >= 0){
                            arrTemp[i-1][j] = 1;
                        }
                        if (i+1 < m1){
                            arrTemp[i+1][j] = 1;
                        }
                        if (j-1 >= 0){
                            arrTemp[i][j-1] = 1;
                        }
                        if (j+1 < n1){
                            arrTemp[i][j+1] = 1;
                        }
                    }
                }
            }
            arr = arrTemp;
            used++;
        }
        return used;
    }

    private static boolean checkHasZero(int[][] arr){
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                if (arr[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
