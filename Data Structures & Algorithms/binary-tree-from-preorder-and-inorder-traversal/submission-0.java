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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }

        return buildT(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, mp);
    }

    private TreeNode buildT(int[] preorder, int prestart, int preend, 
                            int[] inorder, int instart, int inend, Map<Integer, Integer> map){
        if( prestart > preend||  instart >  inend) return null;

        TreeNode node = new TreeNode(preorder[prestart]);

        int rootInd = map.get(node.val);
        int numsLeft = rootInd - instart;

        node.left = buildT(preorder, prestart+1, prestart+numsLeft, inorder, instart, rootInd-1, map );
        node.right = buildT(preorder, prestart+numsLeft+1, preend, inorder, rootInd+1, inend, map );

        return node;
    } 
}
