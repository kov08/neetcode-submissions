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
    public int maxPathSum(TreeNode root) {
    int[] maxV = new int[1];
    maxV[0] = Integer.MIN_VALUE;
    int ans = maxSum(root, maxV);

    return maxV[0];
    }

    private int maxSum(TreeNode root, int[] max){
        if(root == null) return 0;

        int leftS = maxSum(root.left, max);
        int rightS = maxSum(root.right, max);
        if(leftS < 0 ) leftS = 0;
        if(rightS < 0 ) rightS = 0;

        max[0] = Math.max(max[0], root.val + leftS + rightS);

        return root.val + Math.max(leftS, rightS);
    }
}
