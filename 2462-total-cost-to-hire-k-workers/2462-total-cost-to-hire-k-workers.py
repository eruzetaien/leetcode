class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        n = len(costs)
        total_cost = 0
        heap = []

        i, j = 0, n - 1

        for _ in range(candidates):
            if i <= j:
                heapq.heappush(heap, (costs[i], i, 'L'))
                i += 1
            if i <= j:
                heapq.heappush(heap, (costs[j], j, 'R'))
                j -= 1

        for _ in range(k):
            cost, index, side = heapq.heappop(heap)
            total_cost += cost

            if i <= j:
                if side == 'L':
                    heapq.heappush(heap, (costs[i], i, 'L'))
                    i += 1
                else:  # side == 'R'
                    heapq.heappush(heap, (costs[j], j, 'R'))
                    j -= 1

        return total_cost
