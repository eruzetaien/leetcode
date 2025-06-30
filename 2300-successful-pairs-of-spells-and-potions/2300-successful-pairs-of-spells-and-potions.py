class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        m = len(potions)
        res = []

        for spell in spells:
            if spell == 0:
                res.append(0)
                continue

            min_required = math.ceil(success / spell) 
            idx = bisect_left(potions, min_required) # binary search
            res.append(m - idx)

        return res