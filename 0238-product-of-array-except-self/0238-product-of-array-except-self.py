class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        total = 1
        zero_count = 0

        for i in range(len(nums)):
            if (nums[i] == 0):
                zero_count += 1
                continue
            total *= nums[i]

        result = []
        if (zero_count >= 2):
            for i in range(len(nums)):
                result.append(0)
            return result

        for i in range(len(nums)):
            if (nums[i] == 0):
                result.append(total)
            elif (zero_count == 1):
                result.append(0)
            else :
                result.append(int(total/nums[i]))

        return result
        