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
    private static class SubtreeInfo {
        final int height;
        final int diameter;

        SubtreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return getSubstreeInfo(root).diameter;
    }

    private SubtreeInfo getSubstreeInfo(TreeNode root) {
        if (root == null) {
            return new SubtreeInfo(0, 0);
        }

        SubtreeInfo left = getSubstreeInfo(root.left);
        SubtreeInfo right = getSubstreeInfo(root.right);

        int height = Math.max(left.height, right.height) + 1;

        int diameterThroughRoot = left.height + right.height;
        int diameter = Math.max(
            diameterThroughRoot,
            Math.max(left.diameter, right.diameter)
        );

        return new SubtreeInfo(height, diameter);
    }
}