# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        # Find the middle of the linked list using slow and fast pointers
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse the second half of the linked list
        prev = None
        current = slow
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        
        # Traverse both halves and compute the twin sums
        max_sum = 0
        first_half = head
        second_half = prev  
        while second_half:
            current_sum = first_half.val + second_half.val
            if current_sum > max_sum:
                max_sum = current_sum
            first_half = first_half.next
            second_half = second_half.next
        
        return max_sum
        