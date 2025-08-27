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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pointer = head;
        ListNode prevPointer = dummyHead;
        while (pointer != null){
            if (pointer.next != null && pointer.next.val == pointer.val){
                while (pointer.next != null && pointer.next.val == pointer.val){
                    pointer = pointer.next;
                }
                prevPointer.next = pointer.next;
            } else {
                prevPointer = pointer;
            }
            pointer = pointer.next;
        }

        return dummyHead.next;
    }
}