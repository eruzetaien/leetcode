class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        zero_cols : List[int] = []
        zero_rows : List[int] = []
        m : int = len(matrix)
        n : int = len(matrix[0])

        for i in range(m):
            for j in range(n):
                if (matrix[i][j] == 0):
                    zero_rows.append(i)
                    zero_cols.append(j)
        
        for i in range(m):
            for j in range(n):
                if (i in zero_rows or j in zero_cols):
                    matrix[i][j] = 0
