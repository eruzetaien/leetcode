class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        m, n = len(maze), len(maze[0])
        
        start_row, start_col = entrance[0], entrance[1]
        queue = [(start_row, start_col, 0)]
        maze[start_row][start_col] = '+'
        
        total_step = -1
        directions = [(1,0), (-1,0), (0,1), (0,-1)]
        while (queue):
            row, col, step = queue.pop(0)
            is_in_border = row == 0 or col == 0 or row == m-1 or col == n-1
            is_in_entrance = row == entrance[0] and col == entrance[1]

            if (is_in_border and not is_in_entrance):
                total_step = step
                break

            for direction in directions:
                new_row = row + direction[0]
                new_col = col + direction[1]

                if (new_row >= m or new_col >= n or new_row < 0 or new_col < 0):
                    continue

                if (maze[new_row][new_col] == '.'):
                    queue.append((new_row,new_col, step+1))
                    maze[new_row][new_col] = '+' # visited

        return total_step
        
        