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
    public int diameterOfBinaryTree(TreeNode root) {
        // sanity check
        if (root == null) {
            return 0;
        }

        // get diameter
        int[] maxDiameter = new int[]{0};
        getHeight(root, maxDiameter);
        return maxDiameter[0];
    }

    // get height of the tree
    // height: count of the node along the longest path from the root to the leaf node
    private int getHeight(TreeNode root, int[] maxDiameter) {
        // sanity check and base case
        if (root == null) {
            return 0;
        }

        // get height
        int h1 = getHeight(root.left, maxDiameter);
        int h2 = getHeight(root.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], h1 + h2);
        return Math.max(h1, h2) + 1;
    }
}
