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
    public int maxDepth(TreeNode root) {
        // int ans = 0; 
        return dfs(root);
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;

        return Math.max(1 + dfs(node.left), 1 + dfs(node.right));
    }
}
// TC: O(N) vis every node
// SC: O(H) depth of call stack