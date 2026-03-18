class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m:int = len(num1)
        n:int = len(num2)

        sum: int = 0

        for i in range(m):
            for j in range(n):
                num1_int: int = (ord(num1[i]) - ord('0')) * (10 ** (m-i-1))
                num2_int: int = (ord(num2[j]) - ord('0')) * (10 ** (n-j-1))

                sum += num1_int * num2_int
        return str(sum)