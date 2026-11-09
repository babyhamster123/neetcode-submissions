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
        // sanity check
        if (root == null) {
            return 0;
        }

        // check good nodes
        return goodNodes(root, Integer.MIN_VALUE);
    }

    // given the current root and the max value seen so far along the path to it, the max, return the good node count
    private int goodNodes(TreeNode root, int max) {
        // sanity check
        if (root == null) {
            return 0;
        }
        
        int left = goodNodes(root.left, Math.max(max, root.val));
        int right = goodNodes(root.right, Math.max(max, root.val));
        return left + right + (root.val >= max ? 1 : 0);
    }
}
