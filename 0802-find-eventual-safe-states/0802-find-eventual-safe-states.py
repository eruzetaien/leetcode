class Solution:
    def eventualSafeNodes(self, graph):
        n = len(graph)
        color = [0] * n  # 0 = unvisited, 1 = visiting, 2 = safe

        def dfs(node):
            if color[node] != 0:
                return color[node] == 2
            
            color[node] = 1 
            for nei in graph[node]:
                if not dfs(nei):
                    return False # Cycle 
            color[node] = 2 
            return True

        safe_nodes = []
        for i in range(n):
            if dfs(i):
                safe_nodes.append(i)

        return safe_nodes