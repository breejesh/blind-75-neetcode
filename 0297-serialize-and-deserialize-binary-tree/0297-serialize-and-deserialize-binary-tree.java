/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String nullNode = "N";
    private String delim = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        createTreeString(root, str);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        AtomicInteger index = new AtomicInteger(0);
        return createTree(data.split(delim), index);
    }

    private TreeNode createTree(String[] data, AtomicInteger index) {
        if (nullNode.equals(data[index.get()])) {
            index.incrementAndGet();
            return null;
        } else {
            int val = Integer.parseInt(data[index.get()]);
            index.incrementAndGet();
            TreeNode node = new TreeNode();
            node.val = val;
            node.left = createTree(data, index);
            node.right = createTree(data, index);
            return node;
        }
    }

    private void createTreeString(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append(nullNode);
            str.append(delim);
        } else {
            str.append(String.valueOf(root.val));
            str.append(delim);
            createTreeString(root.left, str);
            createTreeString(root.right, str);
        }
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
