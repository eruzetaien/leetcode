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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<NodeLevel> queue = new LinkedList<>();
        queue.offer(new NodeLevel(root,0));
        
        double currSum = 0;
        int currCount = 0;
        int currLevel = 0;
        while (!queue.isEmpty()){
            NodeLevel pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if (node.right != null)
                queue.offer(new NodeLevel(node.right, level + 1));
            
            if (node.left != null)
                queue.offer(new NodeLevel(node.left, level + 1));

            if (level != currLevel){
                result.add(currSum/currCount);
                currSum = 0;
                currCount = 0;
                currLevel = level;
            }
            currSum += node.val;
            currCount += 1;
        }
        result.add((double) currSum/currCount);

        return result;
    }

    private class NodeLevel{
        public TreeNode node;
        public int level;

        public NodeLevel(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
}