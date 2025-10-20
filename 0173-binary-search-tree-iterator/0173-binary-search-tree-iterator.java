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
class BSTIterator {
    private Stack<TreeNode> stack =  new Stack<>();

    public BSTIterator(TreeNode root) {
        if (root == null)
            return;

        TreeNode pointer = root;
        stack.push(pointer);
        while(pointer.left != null){
            pointer = pointer.left;
            stack.push(pointer);
        }
    }
    
    public int next() {
        TreeNode nextNode = stack.pop();
        TreeNode pointer = nextNode;
        if (pointer.right != null){
            pointer = pointer.right;
            stack.push(pointer);
            while (pointer.left != null){
                pointer = pointer.left;
                stack.push(pointer);
            }
        }
        return nextNode.val;
    }
    
    public boolean hasNext() {
        return !stack.empty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */