class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        n : int = len(mat)
        if n == 1:
            return mat[n-1][n-1]

        sum : int = 0
        for i in range(n):
            sum += mat[i][i]
        
        for i in range(n):
            for j in range(n):
                if j == n - 1 - i:
                    sum += mat[i][j]

        if (n % 2 == 1):
            center : int = int((n + 1)/2) - 1
            sum -= mat[center][center]
        return sum