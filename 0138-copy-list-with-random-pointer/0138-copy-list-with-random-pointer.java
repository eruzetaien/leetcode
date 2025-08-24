/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node pointer = head;
        
        // Insert cloned nodes after each original node
        while(pointer != null){
            Node newNode = new Node(pointer.val);

            newNode.next = pointer.next;
            pointer.next = newNode;
            pointer = newNode.next;
        }

        // Assign random pointers
        pointer = head;
        while(pointer != null){
            if (pointer.random != null){
                Node clone = pointer.next;
                Node randomClone = pointer.random.next;

                clone.random = randomClone; 
            }
            pointer = pointer.next.next ;
        }

        // Separate the two lists
        pointer = head;
        Node newHead = head.next;
        while(pointer != null){
            Node clone = pointer.next;
            pointer.next = clone.next;
            if (clone.next != null) {
                clone.next = clone.next.next;
            }
            pointer = pointer.next;
        }

        return newHead;

        
    }
}