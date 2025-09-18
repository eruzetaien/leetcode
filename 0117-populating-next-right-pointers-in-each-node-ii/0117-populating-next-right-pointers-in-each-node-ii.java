/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Queue<NodeAndLevel> queue = new LinkedList<>();
        queue.offer(new NodeAndLevel(root,0));

        while (! queue.isEmpty()){
            NodeAndLevel nodeAndLevel = queue.poll();
            Node node = nodeAndLevel.node;
            int level = nodeAndLevel.level;

            NodeAndLevel nextNodeAndLevel = queue.peek();
            if (nextNodeAndLevel != null && nextNodeAndLevel.level == level ){
                node.next = nextNodeAndLevel.node;
            }

            if (node.left != null)
                queue.offer(new NodeAndLevel(node.left, level+1));
            if (node.right != null)
                queue.offer(new NodeAndLevel(node.right, level+1));
        }
        return root;
    }

    class NodeAndLevel { 
        public final Node node; 
        public final int level; 
        public NodeAndLevel(Node node, int level) { 
            this.node = node; 
            this.level = level; 
        } 
    } 

}