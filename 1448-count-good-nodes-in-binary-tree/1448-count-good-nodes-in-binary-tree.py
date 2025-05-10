# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        current_max = float('-inf')
        stack = [(root,current_max)]
        total_good = 0
        while stack:
            node, current_max = stack.pop()
            if (node.val >= current_max):
                total_good += 1
                current_max = node.val
            
            if node.right:
                stack.append((node.right,current_max))
            if node.left:
                stack.append((node.left, current_max))

        return total_good