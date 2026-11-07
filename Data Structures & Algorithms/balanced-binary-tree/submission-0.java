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
    public boolean isBalanced(TreeNode root) {
        // sanity check
        if (root == null) {
            return true;
        }

        return getTreeInfo(root).isBalanced;
    }

    public TreeInfo getTreeInfo(TreeNode root) {
        // sanity check
        if (root == null) {
            return new TreeInfo(true, 0);
        }

        // recursively check balance
        TreeInfo left = getTreeInfo(root.left);
        TreeInfo right = getTreeInfo(root.right);
        if (!left.isBalanced || !right.isBalanced || Math.abs(left.height - right.height) >= 2) {
            return new TreeInfo(false, -1);
        }
        return new TreeInfo(true, Math.max(left.height, right.height) + 1);
    }

    private class TreeInfo {
        private boolean isBalanced;
        private int height;
        private TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
