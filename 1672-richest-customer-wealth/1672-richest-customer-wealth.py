class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        max_wealth : int = 0
        for customer_wealth in accounts:
            total_wealth = sum(customer_wealth)
            max_wealth = max(total_wealth, max_wealth)
        return max_wealth