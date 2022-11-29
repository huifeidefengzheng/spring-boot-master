package com.dexing.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个以顺序储存结构存储整数值的完全二叉树序列（最多1000个整数），请找出此完全二叉树的所有非叶子节点部分，然后采用后序遍历方式将此部分树（不包含叶子）输出。
 * 1、只有一个节点的树，此节点认定为根节点（非叶子）。
 * 2、此完全二叉树并非满二叉树，可能存在倒数第二层出现叶子或者无右叶子的情况
 * 其他说明：二叉树的后序遍历是基于根来说的，遍历顺序为：左-右-根 根输出
 * 输入描述:
 * 一个通过空格分割的整数序列字符串
 * 输出描述:
 * 非叶子部分树结构
 * 示例1
 * 输入
 * 1 2 3 4 5 6 7
 * 输出
 * 2 3 1
 * 说明
 * 找到非叶子部分树结构，然后采用后续遍历输出
 * 备注:
 * 输出数字以空格分隔
 */
public class D2476ErChaShu {
    private static List<TreeNode> nodes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length+1];
        for (int i = 1; i <= input.length; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }
        buildTree(arr);
        //检查叶子节点
        for (int i = 0; i < nodes.size(); i++) {
            int degree = 0;
            if (nodes.get(i).left != null){
                degree++;
            }
            if (nodes.get(i).right != null){
                degree++;
            }
            nodes.get(i).degree = degree;
        }
        afterPrint(nodes.get(1));
    }

    private static void buildTree(int[] arr){
        nodes.add(new TreeNode(0,null,null));
        //先将所有的节点放到数组中
        for (int i = 1; i < arr.length; i++) {
            nodes.add(new TreeNode(arr[i],null,null));
        }
        for (int i = 1; i < nodes.size(); i++) {
            if (2 * i < nodes.size()){
                nodes.get(i).left = nodes.get(2 * i);
            }
            if (2 * i +1 < nodes.size()){
                nodes.get(i).right = nodes.get(2 * i +1);
            }
        }
    }

    private static void print(TreeNode node){
        //只输出非叶子节点
        if (node.degree != 0){
            System.out.println(node.val);
        }
    }
    //前序遍历 根[根输出] 左 右
    private static void prePrint(TreeNode node){
        print(node);
        if (node.left != null){
            prePrint(node.left);
        }
        if (node.right != null){
            prePrint(node.right);
        }
    }

    //中序遍历  左 根[根输出] 右
    private static void middlePrint(TreeNode node){
        if (node.left != null){
            middlePrint(node.left);
        }
        print(node);
        if (node.right != null){
            middlePrint(node.right);
        }
    }

    //后续遍历 左-右-根[根输出]
    private static void afterPrint(TreeNode node){
        if (node.left != null){
            afterPrint(node.left);
        }
        if (node.right != null){
            afterPrint(node.right);
        }
        print(node);
    }

    private static class TreeNode{
        private int degree;
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
