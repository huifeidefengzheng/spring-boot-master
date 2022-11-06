package com.dexing.niuke;



import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrder {


    /**
     *
     * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     * 例如：
     * 给定的二叉树是{3,9,20,#,#,15,7},
     * 该二叉树层序遍历的结果是
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> treeNodes = new ArrayDeque<TreeNode>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            ArrayList<Integer> integers = new ArrayList<>();
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = treeNodes.poll();
                integers.add(poll.val);
                if (poll.left != null)
                    treeNodes.add(poll.left);
                if (poll.right != null)
                    treeNodes.add(poll.right);
            }
            lists.add(integers);
        }
        return lists;
    }
}
