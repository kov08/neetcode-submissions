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
    public int goodNodes(TreeNode root) {
        // visit every node and check weather it is bigger than root node
        // if not return if yes proceed further
        // We need to pass max value untill the current node if the node value is greater than that value 
        // increase the ans by 1 as we consider that as a good path

        return rec(root, root.val);
    }

    private int rec(TreeNode node, int maxVal){
        if(node == null) return 0;
        int count = 0;

        if(node.val >= maxVal){
            maxVal = node.val;
            count = 1;
        }
        
        count += rec(node.left, maxVal);
        count += rec(node.right, maxVal);

        return count;
    }
}
