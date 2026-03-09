class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        dirs : List[Tuple[int,int]] = [(0,1), (1,0), (0,-1), (-1,0)]
        dir : int = 0

        m : int = len(matrix)
        n : int = len(matrix[0])

        output : List[int] = []
        i : int = 0 
        j : int = 0
        visited = set()
        while i < m and j < n and len(visited) < m*n:
            visited.add((i,j))
            output.append(matrix[i][j])
            new_i : int = i + dirs[dir][0]
            new_j : int = j + dirs[dir][1]
            if (new_i >= m or new_j >= n or new_i < 0 or new_j < 0) or (new_i,new_j) in visited:
                dir = (dir + 1) % 4
                new_i = i + dirs[dir][0]
                new_j = j + dirs[dir][1]
            
            i = new_i
            j = new_j
        return output
