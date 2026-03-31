class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        neighbors: List[List[int]] = [[] for _ in range(n)]
        
        reorder_edges: Set[int,int] = set()
        for con in connections:
            neighbors[con[0]].append(con[1])
            neighbors[con[1]].append(con[0])
            reorder_edges.add((con[1],con[0]))

        print(neighbors)

        reorder_times: int = 0
        visited: Set[int] = set()
        stack: List[int] = [0]
        while(stack):
            city: int = stack.pop()
            visited.add(city)

            for neigh in neighbors[city]:
                if neigh not in visited:
                    if (neigh,city) in reorder_edges:
                        reorder_times += 1
                    stack.append(neigh)

            print(city, neigh, reorder_times)

        return reorder_times
