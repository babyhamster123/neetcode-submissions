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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // sanity check
        if (p == null || q == null) {
            return p == q;
        } 

        // check if same recursively
        Boolean isSameLeft = isSameTree(p.left, q.left); 
        Boolean isSameRight = isSameTree(p.right, q.right);
        if (!isSameLeft || !isSameRight) {
            return false;
        }
        return p.val == q.val;
    }
}
