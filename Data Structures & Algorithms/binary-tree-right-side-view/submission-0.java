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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                TreeNode n = q.peek();
                if(i == 0) ans.add(n.val);
                if(n.right != null) q.add(n.right);
                if(n.left != null) q.add(n.left);
                q.poll();
            }
        }
        return ans;

        // level order traversal
        // add right in the que first and add first element while iterating in the ans array

    }
}
