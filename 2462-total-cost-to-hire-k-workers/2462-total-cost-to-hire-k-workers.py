class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        n = len(costs)
        total_cost = 0
        left = costs[:candidates]
        right = costs[max(candidates, n - candidates):]

        heapq.heapify(left)
        heapq.heapify(right)

        i, j = candidates, n - candidates - 1

        for _ in range(k):
            if not left:
                val = heapq.heappop(right)
            elif not right:
                val = heapq.heappop(left)
            elif left[0] <= right[0]:
                val = heapq.heappop(left)
            else:
                val = heapq.heappop(right)
            total_cost += val

            if i <= j:
                if len(left) < candidates:
                    heapq.heappush(left, costs[i])
                    i += 1
                elif len(right) < candidates:
                    heapq.heappush(right, costs[j])
                    j -= 1

        return total_cost
