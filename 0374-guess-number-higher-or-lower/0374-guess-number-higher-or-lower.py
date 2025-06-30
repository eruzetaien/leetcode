# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        left = 1
        right = n

        while (True):
            guess_num = (left+right) // 2 

            guess_result = guess(guess_num)
            if (guess_result == 0):
                return guess_num
            elif (guess_result == -1):
                right = guess_num - 1
            else:
                left = guess_num + 1
