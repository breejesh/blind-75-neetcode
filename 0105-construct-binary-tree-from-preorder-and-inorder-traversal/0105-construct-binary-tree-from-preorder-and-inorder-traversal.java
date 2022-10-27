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
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        root.left = null;
        root.right = null;
        if (preorder.length > 1) {
            Set<Integer> leftTreeElements = new HashSet();
            Set<Integer> rightTreeElements = new HashSet();
            boolean midFound = false;
            for (int i = 0; i < inorder.length; i++) {
                if (!midFound && inorder[i] == preorder[0]) {
                    midFound = true;
                } else if (midFound) {
                    rightTreeElements.add(inorder[i]);
                } else {
                    leftTreeElements.add(inorder[i]);
                }
            }
            int[] preorderLeft = new int[leftTreeElements.size()];
            int[] preorderRight = new int[rightTreeElements.size()];
            for (int i = 0, leftCount = 0, rightCount = 0; i < preorder.length; i++) {
                if (leftTreeElements.contains(preorder[i])) {
                    preorderLeft[leftCount] = preorder[i];
                    leftCount++;
                } else if (rightTreeElements.contains(preorder[i])) {
                    preorderRight[rightCount] = preorder[i];
                    rightCount++;
                }
            }
            int[] inorderLeft = new int[leftTreeElements.size()];
            int[] inorderRight = new int[rightTreeElements.size()];

            for (int i = 0, leftCount = 0, rightCount = 0; i < inorder.length; i++) {
                if (leftTreeElements.contains(inorder[i])) {
                    inorderLeft[leftCount] = inorder[i];
                    leftCount++;
                } else if (rightTreeElements.contains(inorder[i])) {
                    inorderRight[rightCount] = inorder[i];
                    rightCount++;
                }
            }
            if (leftTreeElements.size() > 0) {
                TreeNode left = buildTree(preorderLeft, inorderLeft);
                root.left = left;
            }
            if (rightTreeElements.size() > 0) {
                TreeNode right = buildTree(preorderRight, inorderRight);
                root.right = right;
            }
        }
        return root;
    }
}
