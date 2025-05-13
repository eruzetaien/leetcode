# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.max_length = 0
        
        def dfs(node, is_left, length):
            if not node:
                return
            # Update the global max_length
            self.max_length = max(self.max_length, length)
            
            # If last move was left, now we go right
            dfs(node.right, False, length + 1 if is_left else 1)
            # If last move was right, now we go left
            dfs(node.left, True, length + 1 if not is_left else 1)
        
        dfs(root.left, True, 1)   # first move is left
        dfs(root.right, False, 1) # first move is right
        
        return self.max_length