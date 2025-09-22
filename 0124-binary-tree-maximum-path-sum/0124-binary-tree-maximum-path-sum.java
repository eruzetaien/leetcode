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
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum; 

    }

    private int dfs(TreeNode root){
        if (root == null)
            return 0;

        int maxLeft = Math.max(0, dfs(root.left));
        int maxRight = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, root.val + maxLeft + maxRight);

        return Math.max(root.val + maxLeft, root.val + maxRight);
    }
}