class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        graph = defaultdict(list)
        for a, b in connections:
            graph[a].append((b, 1))  
            graph[b].append((a, 0))  
        
        visited = set()
        changes = 0

        def dfs(node: int):
            nonlocal changes
            visited.add(node)
            for neighbor, needs_change in graph[node]:
                if neighbor not in visited:
                    changes += needs_change
                    dfs(neighbor)
        
        dfs(0)
        return changes

