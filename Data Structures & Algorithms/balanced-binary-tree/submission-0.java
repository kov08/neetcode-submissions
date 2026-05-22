/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return hei(root) != -1;
    }

    private int hei(TreeNode node){
        if(node == null) return 0;
        
        int lH = hei(node.left);
        if(lH == -1) return -1;
        int rH = hei(node.right);
        if(rH == -1) return -1;

        if(Math.abs( lH - rH) > 1) return -1;
        return 1 + Math.max(lH, rH);
    }
}
