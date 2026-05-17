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
    int longestPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = rec(root);
        return longestPath;
    }

    private int rec(TreeNode root){
        if(root == null) return 0;

        int l = rec(root.left);
        int r = rec(root.right);
        longestPath = Math.max(longestPath, l + r);
        return 1 + Math.max(l,r);
    }
}

// TC: O(N) N: depth of the tree
// SC: O(H) H: stack size of the recusrion (N if skewed tree like linkedlist and logN for perfectly balanced tree) 
