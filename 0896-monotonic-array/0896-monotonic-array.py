class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        increasing = True
        decreasing = True
        for i in range(1, len(nums)):
            if nums[i-1] > nums[i]:
                increasing = False
            elif nums[i-1] < nums[i]:
                decreasing = False
        return increasing or decreasing