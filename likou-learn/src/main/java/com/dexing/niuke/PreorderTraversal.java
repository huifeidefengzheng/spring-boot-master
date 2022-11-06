package com.dexing.niuke;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        preorder(list,root);
        int[] integer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            integer[i] = list.get(i);
        }
        return integer;
    }

    private void preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(list,root.left);
        preorder(list,root.right);
    }

    public int[] preorderTraversal2 (TreeNode root) {
        //添加遍历结果的数组
        List<Integer> list = new ArrayList();
        Stack<TreeNode> s = new Stack<TreeNode>();
        //空树返回空数组
        if(root == null)
            return new int[0];
        //根节点先进栈
        s.push(root);
        while(!s.isEmpty()){
            //每次栈顶就是访问的元素
            TreeNode node = s.pop();
            list.add(node.val);
            //如果右边还有右子节点进栈
            if(node.right != null)
                s.push(node.right);
            //如果左边还有左子节点进栈
            if(node.left != null)
                s.push(node.left);
        }
        //返回的结果
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
