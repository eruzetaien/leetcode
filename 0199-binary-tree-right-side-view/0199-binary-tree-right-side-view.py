# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        stack = [(root,0)]

        level = -1
        result = []
        while len(stack) > 0 :
            node, curr_level =  stack.pop()
            if (node == None):
                continue

            if curr_level > level :
                level = curr_level
                result.append(node.val)
            
            if (node.left != None):
                stack.append((node.left, curr_level + 1))

            if (node.right != None):    
                stack.append((node.right, curr_level + 1))
            

        return result
        