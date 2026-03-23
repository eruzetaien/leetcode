class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n: int = len(isConnected)
        visited: List[bool] = [False] * n

        def dfs(city):
            for neighbor in range(n):
                if isConnected[city][neighbor] == 1 and not visited[neighbor]:
                    visited[neighbor] = True
                    dfs(neighbor)

        provinces: int = 0
        for i in range(n):
            if not visited[i]:
                dfs(i)
                provinces += 1

        return provinces