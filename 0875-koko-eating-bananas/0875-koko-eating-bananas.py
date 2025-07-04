class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        result = right
        
        piles.sort()

        while left <= right:
            mid = (left + right) // 2
            total_hours = 0
            for pile in piles:
                total_hours += math.ceil(pile / mid)
            
            if total_hours <= h:
                result = min(result, mid)
                right = mid - 1
            else:
                left = mid + 1
        
        return result