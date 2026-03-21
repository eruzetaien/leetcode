# Definition for singly-linked list.
# class ListNode:
#     def init(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head1: Optional[ListNode] = l1
        head2: Optional[ListNode] = l2
        
        result_head: Optional[ListNode] = ListNode()
        result_sum: Optional[ListNode] = result_head

        last_node = result_head
        while (l1 and l2):
            curr_sum: int = l1.val + l2.val + result_sum.val
            reminder: int = curr_sum // 10
            curr_sum = curr_sum % 10

            result_sum.val = curr_sum
            result_sum.next = ListNode(reminder)
            
            last_node = result_sum
            result_sum = result_sum.next


            l1 = l1.next
            l2 = l2.next

        while (l1):
            curr_sum: int = l1.val + result_sum.val
            reminder: int = curr_sum // 10
            curr_sum = curr_sum % 10

            result_sum.val = curr_sum
            result_sum.next = ListNode(reminder)
            
            last_node = result_sum
            result_sum = result_sum.next

            l1 = l1.next

        while (l2):
            curr_sum: int = l2.val + result_sum.val
            reminder: int = curr_sum // 10
            curr_sum = curr_sum % 10

            result_sum.val = curr_sum
            result_sum.next = ListNode(reminder)
            
            last_node = result_sum
            result_sum = result_sum.next

            l2 = l2.next

        if (result_sum.val == 0):
            last_node.next = None

        return result_head