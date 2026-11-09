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
    public boolean isValidBST(TreeNode root) {
        // sanity check
        if (root == null) {
            return true;
        }

        // isValidBST
        return getTreeInfo(root).isBST;
    }
    
    private TreeInfo getTreeInfo(TreeNode root) {
        // sanity check
        if (root == null) {
            return new TreeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        TreeInfo left = getTreeInfo(root.left);
        TreeInfo right = getTreeInfo(root.right);
        if (!left.isBST || !right.isBST) {
            return new TreeInfo(false, 0, 0);
        }
        if (left.max >= root.val || right.min <= root.val) {
            return new TreeInfo(false, 0, 0);
        }

        int min = Math.min(left.min, root.val);
        int max = Math.max(right.max, root.val);
        return new TreeInfo(true, min, max);
    }

    private class TreeInfo {
        private int min;
        private int max;
        private boolean isBST;

        private TreeInfo(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}
