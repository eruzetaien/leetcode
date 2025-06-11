class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        n = len(costs)
        left_candidates = costs[:candidates]
        right_candidates = costs[max((n-candidates), candidates):]

        heapq.heapify(left_candidates)
        heapq.heapify(right_candidates)

        left_pointer = candidates
        right_pointer = (n-candidates) - 1

        total_costs = 0
        for _ in range(k):
            if (not left_candidates):
                total_costs += heapq.heappop(right_candidates)
                if (len(right_candidates) < candidates and right_pointer >= left_pointer):
                    heapq.heappush(right_candidates, costs[right_pointer])
                    right_pointer -= 1
            elif (not right_candidates):
                total_costs += heapq.heappop(left_candidates)
                if (len(left_candidates) < candidates and left_pointer <= right_pointer):
                    heapq.heappush(left_candidates, costs[left_pointer])
                    left_pointer += 1
            elif (left_candidates[0] <= right_candidates[0]):
                total_costs += heapq.heappop(left_candidates)
                if (len(left_candidates) < candidates and left_pointer <= right_pointer):
                    heapq.heappush(left_candidates, costs[left_pointer])
                    left_pointer += 1
            else :
                total_costs += heapq.heappop(right_candidates)
                if (len(right_candidates) < candidates and right_pointer >= left_pointer):
                    heapq.heappush(right_candidates, costs[right_pointer])
                    right_pointer -= 1
        
        return total_costs
