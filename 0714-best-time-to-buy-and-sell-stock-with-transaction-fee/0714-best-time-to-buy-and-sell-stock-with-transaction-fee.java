class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash = 0;
        int hold = prices[0];

        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, prices[i] - hold - fee);
            hold = Math.min(hold, prices[i] - cash);
            // if cash updated (cash = prices[i] - hold - fee), 
            // we compare hold with prices[i] - (prices[i] - hold - fee)
            // hold vs (hold + fee), so hold will not be updated, 
            // this prevent we buy and sell at the same time 
        }

        return cash;
    }
}