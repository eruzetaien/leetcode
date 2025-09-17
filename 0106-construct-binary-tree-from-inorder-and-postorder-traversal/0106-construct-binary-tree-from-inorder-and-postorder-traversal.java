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
    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        inorderMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            inorderMap.put(inorder[i], i);
        }

        postIndex = n -1;
        return build(postorder, 0, n-1);
    }

    private TreeNode build(int[] postorder, int left, int right){
        if (left > right)
            return null;

        int rootVal = postorder[postIndex];
        postIndex--;

        TreeNode root = new TreeNode(rootVal); 

        int inorderIndex = inorderMap.get(rootVal);

        root.right = build(postorder, inorderIndex + 1, right);
        root.left = build(postorder, left, inorderIndex - 1);
        
        return root;
    }

    
}