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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // sanity check
        if (root == null || subRoot == null) {
            return root == subRoot;
        }

        // check subtree
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // sanity check
        if (p == null || q == null) {
            return p == q;
        } 

        // check if same recursively
        boolean isSameLeft = isSameTree(p.left, q.left); 
        boolean isSameRight = isSameTree(p.right, q.right);
        if (!isSameLeft || !isSameRight) {
            return false;
        }
        return p.val == q.val;
    }
}
