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
    public int kthSmallest(TreeNode root, int k) {
        // sanity check
        if (root == null || k < 1) {
            return -1;
        }

        // traverse the tree
        return inorderTraverse(root, k, new int[]{0});
    }

    // in order traverse the tree and return the kth smallest if found or null
    private Integer inorderTraverse(TreeNode root, int k, int[] count) {
        // sanity check
        if (root == null) {
            return null;
        }
        
        // left 
        Integer left = inorderTraverse(root.left, k, count);
        if (left != null) {
            return left;
        }

        // root
        count[0]++;
        if (count[0] == k) {
            return root.val;
        }

        // right
        Integer right = inorderTraverse(root.right, k, count);
        if (right != null) {
            return right;
        }

        return null;
    }
}
