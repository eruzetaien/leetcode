class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reachable: int = 0
        n: int = len(nums)
        
        for i, jump in enumerate(nums):
            if i > max_reachable:
                return False
            max_reachable = max(max_reachable, i + jump)
            if max_reachable >= n - 1:
                return True  
        
        return False  

        
            
        