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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // sanity check
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // traverse, assume root is at level 0 which is the same as the index of the result
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode root, int level, List<List<Integer>> result) {
        // sanity check
        if (root == null) {
            return;
        }

        // add to level
        if (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        List<Integer> levelVals = result.get(level);
        levelVals.add(root.val);

        // traverse left
        traverse(root.left, level + 1, result);

        // traverse right
        traverse(root.right, level + 1, result);
    }
}
