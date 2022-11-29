package com.dexing.od;

import java.util.Scanner;

/**
 * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2N和2N+1，并且我们用值-1代表一个节点为空。
 * 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
 * 输入描述:
 * 输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分隔。注意第一个元素即为根节点的值，即数组的第N个元素对应下标N，下标0在树的表示中没有使用，所以我们省略了。输入的树最多为7层。
 * 输出描述:
 * 输出从根节点到最小叶子节点的路径上，各个节点的值，由空格分隔，用例保证最小叶子节点只有一个。
 * 示例1
 * 输入
 * 3 5 7 -1 -1 2 4
 * 输出
 * 3 7 2
 * 说明
 * 数组存储的二叉树如图，故到最小叶子节点的路径为3 7 2
 * 示例2
 * 输入
 * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
 * 输出
 * 5 8 7 6
 * 说明
 * 数组存储的二叉树如图，故到最小叶子节点的路径为10 8 7 6，注意数组仅存储至最后一个非空节点，故不包含节点“7”右子节点的-1
 */
public class D2270ArrayShu {
    public static void main(String[] args) {//1 2 4 8 16
        // Scanner sc = new Scanner(System.in);
        String[] input = "5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6".split(" ");
        //先找到最小叶子节点所在行  求行号
        int min = Integer.MAX_VALUE;//数组每个元素都是正整数
        int idx = 0;
        for (int i = 1; i < input.length; i++) {
            if (Integer.parseInt(input[i]) != -1 && Integer.parseInt(input[i])<min){
                idx = i;
                min = Integer.parseInt(input[i]);
            }
        }
        int line = calcLine(idx);
        int[] arr = new int[line];
        //line表示行号 start表示该行首个元素
        int start = calcStart(line);//arr[7]
        arr[line-1] = Integer.parseInt(input[idx]);
        //求该值在所在行的序号
        int turnInLine = idx - start + 1 ;
        //求剩余其他行
        line--;
        turnInLine = turnInLine%2 ==0 ? turnInLine/2 : turnInLine/2+1;//3
        while (line > 0){
            start = calcStart(line);//arr
            arr[line-1] = Integer.parseInt(input[turnInLine + start -1 ]);
            line--;
            turnInLine = turnInLine%2 ==0 ? turnInLine/2 : turnInLine/2+1;//2
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int calcStart(int line){
        int total = 0;
        int tem = 0;
        while (line>1){
            total += 1<<tem;
            tem++;
            line--;
        }
        return total;
    }

    //计算在第几行
    private static int calcLine(int line){
        int tem = 0;
        while (line>0){
            int i = 1 << tem;
            line -= i;
            tem++;
        }
        return tem;
    }

    public static void test() {

    }
}
