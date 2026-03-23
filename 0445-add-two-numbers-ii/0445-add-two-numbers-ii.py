# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        ptr1: Optional[ListNode] = l1
        ptr2: Optional[ListNode] = l2
        
        head1: Optional[ListNode] = l1
        head2: Optional[ListNode] = l2
        while(ptr1 or ptr2):
            if (ptr1 == None):
                head1 = ListNode(val=0, next=head1)
            else:
                ptr1 = ptr1.next

            if (ptr2 == None):
                head2 = ListNode(val=0, next=head2)
            else:
                ptr2 = ptr2.next
        
        head = self.addTwoNumbersRec(head1,head2)

        if (head):
            remainder = head.val // 10
            head.val = head.val % 10
            
            if (remainder > 0):
                head = ListNode(val=remainder, next=head) 
        return head
        
    def addTwoNumbersRec(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if (not l1 and not l2):
            return None
        
        next_node: Optional[ListNode] = self.addTwoNumbersRec(l1.next, l2.next)
        
        remainder: int = 0
        if (next_node):
            remainder = next_node.val // 10
            next_node.val = next_node.val % 10

        val: int = remainder + l1.val + l2.val 
        return ListNode(val=val, next=next_node )

