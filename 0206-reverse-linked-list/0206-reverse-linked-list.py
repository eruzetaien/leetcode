# Definition for singly-linked list.
# class ListNode:
#     def init(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head

        prev_node :Optional[ListNode] = None
        curr_node :Optional[ListNode] = head
        next_node :Optional[ListNode] = head.next

        while(curr_node):
            curr_node.next = prev_node
            prev_node = curr_node
            curr_node = next_node
            if (next_node):
                next_node = next_node.next

        return prev_node