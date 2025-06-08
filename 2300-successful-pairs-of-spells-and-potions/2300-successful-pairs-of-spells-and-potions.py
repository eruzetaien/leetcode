class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        m = len(potions)
        result = []

        def binary_search(threshold):
            left, right = 0, m - 1
            while left <= right:
                mid = (left + right) // 2
                if potions[mid] < threshold:
                    left = mid + 1
                else:
                    right = mid - 1
            return left  # first index where potions[i] >= threshold

        for spell in spells:
            threshold = (success + spell - 1) // spell  
            index = binary_search(threshold)
            result.append(m - index)

        return result