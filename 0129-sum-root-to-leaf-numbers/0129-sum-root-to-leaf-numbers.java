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
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        
        Stack<NodeAndDigit> stack = new Stack<>();
        stack.push(new NodeAndDigit(root, Integer.toString(root.val)) );

        int sum = 0;
        while(!stack.isEmpty()){
            NodeAndDigit nodeAndDigit = stack.pop();
            TreeNode node = nodeAndDigit.node;
            String digit = nodeAndDigit.digit;

            if (node.left == null && node.right == null){
                sum += Integer.parseInt(digit);
                continue;
            } 

            if (node.left != null)
                stack.push(new NodeAndDigit(node.left, digit + Integer.toString(node.left.val)) );
            
            if (node.right != null)
                stack.push(new NodeAndDigit(node.right, digit + Integer.toString(node.right.val)) );
        }


        return sum;
    }

    class NodeAndDigit{ 
        public TreeNode node;
        public String digit;

        public NodeAndDigit (TreeNode node, String digit){
            this.node = node;
            this.digit = digit;
        }
    }
}