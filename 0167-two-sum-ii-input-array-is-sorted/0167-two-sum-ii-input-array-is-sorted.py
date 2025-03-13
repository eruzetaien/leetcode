class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        right_pointer = len(numbers) - 1
        left_pointer = 0

        while (left_pointer < right_pointer ):
            sum = numbers[left_pointer] + numbers[right_pointer]
            if (sum == target):
                return [left_pointer+1, right_pointer+1]
            elif (sum > target):
                right_pointer -=1
            else :
                left_pointer +=1 

        return [-1,-1];        
        