class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        n : int = len(nums)
        if (n <= 2):
            return 0

        nums.sort(reverse=True)

        for i in range(n - 2):
            if (nums[i+2] + nums[i+1] > nums[i]):
                return nums[i] + nums[i+1] + nums[i+2]
        return 0