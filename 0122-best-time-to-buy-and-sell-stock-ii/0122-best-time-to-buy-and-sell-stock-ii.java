class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cash = 0;
        int hold = prices[0];

        for (int i = 1; i < n; i++){
            cash = Math.max(cash, prices[i] - hold);
            hold = Math.min(hold, prices[i] - cash);
        }

        return cash;
    }
}