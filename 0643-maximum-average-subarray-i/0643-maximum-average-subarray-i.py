class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        max_average = float('-inf')

        far_left_idx = 0
        num_sum = 0
        num_count = 0
        for i in range(len(nums)):
            num_sum += nums[i]
            num_count += 1
            if (num_count == k):
                curr_average = num_sum / k
                if (curr_average > max_average):
                    max_average = curr_average
                num_sum -= nums[far_left_idx]
                num_count -= 1
                far_left_idx += 1
        
        return max_average
