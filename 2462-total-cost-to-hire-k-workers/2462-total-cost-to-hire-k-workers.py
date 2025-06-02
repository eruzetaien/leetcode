class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        n = len(costs)
        total_cost = 0
        i, j = 0, n - 1

        left_heap = []
        right_heap = []

        # Pre-fill both heaps with up to 'candidates' workers
        for _ in range(candidates):
            if i <= j:
                heapq.heappush(left_heap, (costs[i], i))
                i += 1
            if i <= j:
                heapq.heappush(right_heap, (costs[j], j))
                j -= 1

        for _ in range(k):
            if not right_heap or (left_heap and left_heap[0][0] <= right_heap[0][0]):
                cost, _ = heapq.heappop(left_heap)
                total_cost += cost
                if i <= j:
                    heapq.heappush(left_heap, (costs[i], i))
                    i += 1
            else:
                cost, _ = heapq.heappop(right_heap)
                total_cost += cost
                if i <= j:
                    heapq.heappush(right_heap, (costs[j], j))
                    j -= 1

        return total_cost
