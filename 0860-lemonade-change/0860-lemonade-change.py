class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        cost : int = 5
        money_count = [0, 0] # $10, $5
        for bill in bills:
            change : int = bill - cost
            
            while (change >= 10 and money_count[0] > 0):
                change -= 10
                money_count[0] -= 1
            
            while (change >= 5 and money_count[1] > 0):
                change -= 5
                money_count[1] -= 1
            
            if change > 0:
                return False

            if (bill == 10):
                money_count[0] +=1
            elif (bill == 5):
                money_count[1] +=1

        return True
