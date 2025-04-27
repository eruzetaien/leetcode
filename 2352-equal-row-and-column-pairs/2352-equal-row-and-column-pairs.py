class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        n = len(grid)
        row_counts = {}
        total_pairs = 0
        
        for row in grid:
            row_tuple = tuple(row)
            row_counts[row_tuple] = row_counts.get(row_tuple,0) + 1
        
        for j in range(n):
            column = []
            for i in range(n):
                column.append(grid[i][j])
            col_tuple = tuple(column)
            if col_tuple in row_counts:
                total_pairs += row_counts[col_tuple]
        
        return total_pairs