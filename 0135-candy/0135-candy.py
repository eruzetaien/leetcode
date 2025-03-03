class Solution:
    def candy(self, ratings: List[int]) -> int:
        if (len(ratings) <= 1):
            return len(ratings)

        candies = []
        for i in range (len(ratings)):
            candies.append(1)

        # From front
        for i in range (1, len(ratings)):
            if (ratings[i-1] < ratings[i] and candies[i-1] >= candies[i]):
                candies[i] = candies[i-1] + 1

        # From back
        for i in range ((len(ratings)-1) -1, -1, -1):
            if (ratings[i+1] < ratings[i] and candies[i+1] >= candies[i]):
                candies[i] = candies[i+1] + 1

        total_candies = 0
        for candy in candies:
            total_candies += candy
        
        print(candies)
        

        return total_candies
            
