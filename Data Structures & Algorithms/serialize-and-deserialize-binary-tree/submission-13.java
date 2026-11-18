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

public class Codec {

    private final String seperator = ",";
    private final String nullVal = "NULL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // sanity check
        if (root == null) {
            return null;
        }

        // serialize
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        // sanity check
        if (root == null) {
            sb.append(nullVal).append(seperator); 
            return;
        }

        sb.append(root.val).append(seperator);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // sanity check
        if (data == null || data.isEmpty()) {
            return null;
        }

        // deserialize
        return deserialize(data.split(seperator), new int[]{0});
    }

    private TreeNode deserialize(String[] data, int[] i) {
        // sanity check
        if (data == null || data.length == 0 || i[0] >= data.length) {
            return null;
        }

        String val = data[i[0]];
        if (val.equals(nullVal) || val.isEmpty()) {
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        i[0]++;
        root.left = deserialize(data, i);
        root.right = deserialize(data, i);
        return root;
    }
}
