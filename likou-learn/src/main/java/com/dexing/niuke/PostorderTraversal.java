package com.dexing.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(postorderTraversal2(treeNode));

    }

    /**
     * 给定一个二叉树，返回他的后序遍历的序列。
     * <p>
     * 后序遍历是值按照 左节点->右节点->根节点 的顺序的遍历。
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public static int[] postorderTraversal(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        postorder(list, root);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private static void postorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(list, root.left);
        postorder(list, root.right);
        list.add(root.val);
    }


    public static int[] postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode pop = root;
        stack.push(pop);
        while (!stack.empty()) {

            // 找最左节点
            pop = stack.pop();
            stack1.push(pop);
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
        }
        int[] ints = new int[stack1.size()];
        for (int i = 0; i < stack1.size(); i++) {
            ints[i] = stack1.pop().val;
        }
        return ints;
    }
}
