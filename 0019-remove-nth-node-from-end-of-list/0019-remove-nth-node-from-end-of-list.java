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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode leadPointer = dummyHead;
        ListNode trailPointer = dummyHead;

        for (int i = 0; i<n; i++){
            leadPointer = leadPointer.next;
            if (leadPointer == null){
                return head;
            }
        }

        while (leadPointer.next != null){
            leadPointer = leadPointer.next;
            trailPointer = trailPointer.next;
        }

        trailPointer.next = trailPointer.next.next;
        return dummyHead.next;
    }
}