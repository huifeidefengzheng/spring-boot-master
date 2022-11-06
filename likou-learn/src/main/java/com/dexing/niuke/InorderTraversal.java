package com.dexing.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        s.push(treeNode);
        System.out.println(s);
    }

    /**
     * 给定一个二叉树的根节点root，返回它的中序遍历结果。
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        inorder(list,root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);

    }

    public int[] inorderTraversal2 (TreeNode root) {
        //添加遍历结果的数组
        List<Integer> list = new ArrayList();
        Stack<TreeNode> s = new Stack<TreeNode>();
        //空树返回空数组
        if(root == null)
            return new int[0];
        //当树节点不为空或栈中有节点时
        while(root != null || !s.isEmpty()){
            //每次找到最左节点
            while(root != null){
                s.push(root);
                root = root.left;
            }
            //访问该节点
            TreeNode node = s.pop();
            list.add(node.val);
            //进入右节点
            root = node.right;
        }
        //返回的结果
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
