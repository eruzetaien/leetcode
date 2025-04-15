class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        left_pointer = 0
        right_pointer = len(nums) - 1

        nums = sorted(nums)

        operation_counts = 0
        while (left_pointer < right_pointer):
            sum = nums[left_pointer] + nums[right_pointer]
            if (sum == k):
                operation_counts += 1
                right_pointer -= 1
                left_pointer += 1
            elif (sum > k):
                right_pointer -= 1
            else :
                left_pointer += 1
        
        return operation_counts