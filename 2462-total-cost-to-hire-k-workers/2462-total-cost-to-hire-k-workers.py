class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        n = len(costs)
        
        left_pointer = candidates
        right_pointer = max(candidates,(n-candidates)) - 1

        left_candidates = costs[:left_pointer]
        right_candidates = costs[right_pointer + 1:]

        heapq.heapify(left_candidates)
        heapq.heapify(right_candidates)

        total_cost = 0

        for i in range(k):
            is_candidate_from_left = None
            if (len(left_candidates) <= 0):
                is_candidate_from_left = False
            elif (len(right_candidates) <= 0):
                is_candidate_from_left = True
            elif (left_candidates[0] <= right_candidates[0]):
                is_candidate_from_left = True
            else:
                is_candidate_from_left = False

            if (is_candidate_from_left):
                total_cost += heapq.heappop(left_candidates)
                if (left_pointer <= right_pointer):
                    heapq.heappush(left_candidates, costs[left_pointer])
                    left_pointer += 1
            else :
                total_cost += heapq.heappop(right_candidates)
                if (left_pointer <= right_pointer):
                    heapq.heappush(right_candidates, costs[right_pointer])
                    right_pointer -= 1

        return total_cost