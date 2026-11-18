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
    public int maxPathSum(TreeNode root) {
        // sanity check
        if (root == null) {
            return 0;
        }

        // search
        int[] maxPathSum = new int[]{0};
        int[] maxNode = new int[]{Integer.MIN_VALUE};
        searchMaxPathSum(root, maxPathSum, maxNode); 
        return maxPathSum[0] == 0 ? maxNode[0] : maxPathSum[0];
    }

    // search the max path sum
    // return the max sum of a linked list with root as head as helper value
    private int searchMaxPathSum(TreeNode root, int[] maxPathSum, int[] maxNode) {
        // sanity check
        if (root == null) {
            return 0;
        } 

        // search
        int left = searchMaxPathSum(root.left, maxPathSum, maxNode);
        int right = searchMaxPathSum(root.right, maxPathSum, maxNode);
        maxNode[0] = max(maxNode[0], root.val);
        maxPathSum[0] = max(maxPathSum[0], root.val, left, right, left + root.val, right + root.val, left + right + root.val);
        return max(root.val, left + root.val, right + root.val);
    }
    
    private int max(int m, int... nums) {
        for (int n : nums) {
            m = Math.max(m, n);
        }
        return m;
    }
}
