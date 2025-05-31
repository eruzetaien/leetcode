class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        pairs = sorted(zip(nums2, nums1), reverse=True)  # Sort by nums2 descending
        min_heap = []
        sum_nums1 = 0
        max_score = 0

        for num2, num1 in pairs:
            heapq.heappush(min_heap, num1)
            sum_nums1 += num1

            if len(min_heap) > k:
                sum_nums1 -= heapq.heappop(min_heap)
            
            if len(min_heap) == k:
                max_score = max(max_score, sum_nums1 * num2)

        return max_score