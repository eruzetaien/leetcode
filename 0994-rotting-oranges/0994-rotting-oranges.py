class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        if rows == 0:
            return -1
        cols = len(grid[0])
        
        fresh = 0
        rotten = deque()
        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    rotten.append((r, c))
                elif grid[r][c] == 1:
                    fresh += 1
        minutes = 0
        directions = [(1,0), (0,1), (-1,0), (0,-1)]
        while (rotten and fresh > 0):
            minutes += 1
            rotten_num = len(rotten)
            for i in range(rotten_num):
                row, col = rotten.popleft()
                for dir in directions:
                    new_row, new_col = row + dir[0], col + dir[1]
                    if (0 <= new_row < rows and 0 <= new_col < cols ):
                        if (grid[new_row][new_col] == 1):
                            grid[new_row][new_col] = 2
                            rotten.append((new_row, new_col))
                            fresh -= 1

        return minutes if fresh <= 0 else -1