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
    private class ResultWrapper {
        int overallMax;
        int pathMax;
    }
    
    public int maxPathSum(TreeNode root) {
        ResultWrapper result = calcMaxSum(root);
        return result.overallMax;
    }
    
    public ResultWrapper calcMaxSum(TreeNode node) {
        ResultWrapper result = new ResultWrapper();
        int leftMax = 0;
        int rightMax = 0;
        int overallMax = -1000000;
        
        result.overallMax = -1000000;
        result.pathMax = -1000000;
        
        if(node == null) {
            return result;
        }
        
        if(node.left != null) {
           ResultWrapper leftResult = calcMaxSum(node.left);
            leftMax = leftResult.pathMax;
            if(overallMax < leftResult.overallMax) {
                overallMax = leftResult.overallMax;
            }
        }
        if(node.right != null) {
            ResultWrapper rightResult = calcMaxSum(node.right);
            rightMax = rightResult.pathMax;
            if(overallMax < rightResult.overallMax) {
                overallMax = rightResult.overallMax;
            }

        }
        
        int currentMax = node.val + Math.max(0, rightMax) + Math.max(0, leftMax);
        if(currentMax > overallMax) {
            overallMax = currentMax;
        }
        result.overallMax = overallMax;
        result.pathMax = node.val + Math.max(Math.max(rightMax, leftMax), 0);
        return result;
    }
}