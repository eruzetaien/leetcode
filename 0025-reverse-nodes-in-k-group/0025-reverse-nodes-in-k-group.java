/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1){return head;}

        ListNode resultHead = null;
        ListNode pointer = head;
        ListNode prevTail = null;
        ListNode currHead = head;
        int count = 0;
        while (pointer != null){
            count++;
            if (count == 1){
                // System.out.println(pointer.val);
                currHead = pointer;
            } else if (count == k){
                ListNode nextNode = pointer.next;
                ListNode newHead = reverse(currHead,k);
                ListNode newTail = currHead;
                newTail.next = nextNode;
                if (resultHead == null){
                    resultHead = newHead;
                }
                if (prevTail != null){
                    prevTail.next = newHead;
                }
                prevTail = newTail;
                pointer = newTail;
                count = 0;
            }
            pointer = pointer.next;
        }

        return resultHead;
    }

    public ListNode reverse(ListNode head, int k){
        ListNode prevNode = null;
        ListNode currNode = head;

        for (int i = 0; i < k; i++){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}