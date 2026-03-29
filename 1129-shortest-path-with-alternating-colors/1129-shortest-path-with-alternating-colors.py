class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        shortest_paths: List[int] = [-1] * n

        red_edges: List[List[int]] = [[] for _ in range(n)]
        for edge in redEdges:
            red_edges[edge[0]].append(edge[1])

        blue_edges: List[List[int]] = [[] for _ in range(n)]
        for edge in blueEdges:
            blue_edges[edge[0]].append(edge[1])

        red_visited: List[bool] = [False] * n 
        blue_visited: List[bool] = [False] * n
        
        queue: List[(int, bool, int)] = [(0, 0, 0), (0, 1, 0)] #(node, r/b edge, len path)
        while(queue):
            curr_node, is_from_red, len_path = queue.pop(0)
            curr_shortest = shortest_paths[curr_node]
            if curr_shortest == -1 or len_path < curr_shortest:
                shortest_paths[curr_node] = len_path

            neighs: List[int] = blue_edges[curr_node] if is_from_red else red_edges[curr_node]
            for neigh in neighs:
                if is_from_red:
                    if red_visited[neigh]:
                        continue
                    red_visited[neigh] = True
                else:
                    if blue_visited[neigh]:
                        continue
                    blue_visited[neigh] = True

                queue.append((neigh,not is_from_red, len_path + 1))

        return shortest_paths