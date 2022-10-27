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
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k, 1);
        return result;
    }
    
    private int findKthSmallest(TreeNode root, int k, int index) {
        int nextIndex = index;
        if(root.left != null) {
           nextIndex = findKthSmallest(root.left, k, index);
        }
        // process
        if(nextIndex == k) {
            result = root.val;
        }
        nextIndex = nextIndex + 1;
        if(root.right != null) {
            nextIndex = findKthSmallest(root.right, k, nextIndex);
        }
        return nextIndex;
    }
}