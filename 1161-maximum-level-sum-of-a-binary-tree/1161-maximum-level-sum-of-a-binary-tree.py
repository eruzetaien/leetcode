# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        curr_level = 1
        curr_sum = root.val
        
        max_level = curr_level
        max_sum = curr_sum

        queue = [(root,curr_level)]
        while queue:
            node, level = queue.pop(0)
            if (node == None):
                continue

            if (level > curr_level):
                if (curr_sum > max_sum):
                    max_level = curr_level
                    max_sum = curr_sum

                curr_level = level
                curr_sum = node.val
                
            elif (level == curr_level):
                curr_sum += node.val

            queue.append((node.left,  curr_level +1))
            queue.append((node.right, curr_level +1))


        if (curr_sum > max_sum):
            max_level = curr_level

        return max_level


        