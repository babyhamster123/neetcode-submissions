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
    public List<Integer> rightSideView(TreeNode root) {
        // sanity check
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // treverse level by level and log the right most val
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode n = q.pollFirst();
                // add the right most node's val
                if (i == levelSize - 1) {
                   result.add(n.val);
                }

                if (n.left != null) {
                    q.offerLast(n.left);
                }
                if (n.right != null) {
                    q.offerLast(n.right);
                }
            }
        }

        return result;
    }
}
