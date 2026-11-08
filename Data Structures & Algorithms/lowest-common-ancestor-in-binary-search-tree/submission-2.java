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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // per the assumption stated in the problem
        // sanity check
        if (root == null || p == null || q == null) {
            return null;
        }

        // look for the node whose value is strictly between p and q
        TreeNode curt = root;
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while (curt.val < min || curt.val > max) {
            if (curt.val < min) {
                curt = curt.right;
            } else {
                curt = curt.left;
            }
        }
        return curt;
    }
}
