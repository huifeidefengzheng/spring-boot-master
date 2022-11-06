package com.dexing.likou;

public class Learn0201LongestZigZag {

    public int longestZigZag(TreeNode root) {
        int maxt = 0;
        int rest = findMaxt(root,maxt);
        return rest;
    }
     public int findMaxt(TreeNode root,int maxt) {
        if (root != null && root.right.val == 1 && root.right.left.val ==  1) {
            maxt +=1;
            findMaxt(root.right.left,maxt);
        } else if (root != null && root.left.val == 1 && root.left.right.val ==  1){
            maxt +=1;
            findMaxt(root.left.right,maxt);
        }
        return maxt;
     }
}
