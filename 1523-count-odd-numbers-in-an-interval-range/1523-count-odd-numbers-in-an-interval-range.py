class Solution:
    def countOdds(self, low: int, high: int) -> int:
        count : int = 0

        low_closest_even : int = low
        while low_closest_even % 2 == 1:
            count += 1
            low_closest_even +=1

        high_closest_even : int = high
        while high_closest_even % 2 == 1:
            count += 1
            high_closest_even -=1

        count += int((high_closest_even - low_closest_even) / 2)  
        return count
