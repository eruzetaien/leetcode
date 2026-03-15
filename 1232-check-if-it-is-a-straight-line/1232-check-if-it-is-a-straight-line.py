class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        n : int = len(coordinates)
        if n <= 2:
            return True

        delta_x : float = coordinates[1][0] - coordinates[0][0]
        delta_y : float = coordinates[1][1] - coordinates[0][1]
        grad : float = delta_y / delta_x if delta_x != 0 else float('inf')

        for i in range(1, n-1):
            delta_x = coordinates[i+1][0] - coordinates[i][0]
            delta_y = coordinates[i+1][1] - coordinates[i][1]

            curr_grad : float = delta_y / delta_x if delta_x != 0 else float('inf')            
            if curr_grad != grad:
                return False
        return True