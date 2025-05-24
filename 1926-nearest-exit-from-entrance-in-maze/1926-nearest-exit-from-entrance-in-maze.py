class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        m, n = len(maze), len(maze[0])
        queue = deque()
        queue.append((entrance[0], entrance[1], 0))
        directions = [(-1,0), (1,0), (0,-1), (0,1)]
        
        # Mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+'
        
        while queue:
            r, c, steps = queue.popleft()
            
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                
                if 0 <= nr < m and 0 <= nc < n and maze[nr][nc] == '.':
                    # Check if it's a border and not the entrance
                    if nr == 0 or nr == m-1 or nc == 0 or nc == n-1:
                        return steps + 1
                    maze[nr][nc] = '+'
                    queue.append((nr, nc, steps + 1))
        
        return -1