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
    private int k;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;

        this.k = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null || k == 0) return;

        inorder(node.left);

        this.k -= 1;
        if (k == 0) {
            result = node.val;
            return;
        }

        inorder(node.right);
    }
}