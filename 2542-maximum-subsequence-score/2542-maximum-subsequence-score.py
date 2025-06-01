class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        pairs = sorted(zip(nums2, nums1), reverse=True)  # Sort by nums2 descending
        max_score = 0
        current_sum = 0
        heap = [] 

        for num2, num1 in pairs:
            current_sum += num1
            heapq.heappush(heap, num1)

            if (len(heap) > k):
                current_sum -= heapq.heappop(heap)

            if (len(heap) == k):
                current_score = current_sum * num2 
                if (current_score > max_score):
                    max_score = current_score

        return max_score