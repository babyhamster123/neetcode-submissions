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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // sanity check
        // per the constraint
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, NodeInfo> nodeMap = buildNodeMap(inorder);

        // buildTree
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, nodeMap).node;
    }

    private NodeInfo buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, NodeInfo> nodeMap) {
        // sanity check
        if (preorderStart > preorderEnd) {
            return new NodeInfo(null, -1);
        } 

        NodeInfo rootInfo = nodeMap.get(preorder[preorderStart]);
        TreeNode root = rootInfo.node;
        // count on the left: rootInfo.inoderIndex - inorderStart
        root.left = buildTree(preorder, preorderStart + 1, preorderStart + rootInfo.inorderIndex - inorderStart, inorder, inorderStart, rootInfo.inorderIndex - 1, nodeMap).node;
        root.right = buildTree(preorder, preorderStart + rootInfo.inorderIndex - inorderStart + 1, preorderEnd, inorder, rootInfo.inorderIndex + 1, inorderEnd, nodeMap).node;
        return rootInfo;
    }
    
    private class NodeInfo {
        private TreeNode node;
        private int inorderIndex;
        
        private NodeInfo(TreeNode node, int inorderIndex) {
            this.node = node;
            this.inorderIndex = inorderIndex;
        }

    }
    private Map<Integer, NodeInfo> buildNodeMap(int[] inorder) {
        Map<Integer, NodeInfo> nodeMap = new HashMap<>();
        for (int i = 0; i < inorder.length ;i++) {
            TreeNode tn = new TreeNode(inorder[i]);
            NodeInfo ni = new NodeInfo(tn, i);
            nodeMap.put(inorder[i], ni);
        }
        return nodeMap;
    }
}
