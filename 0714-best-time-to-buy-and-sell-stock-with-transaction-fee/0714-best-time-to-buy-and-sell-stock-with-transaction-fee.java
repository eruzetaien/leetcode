class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash = 0;
        int hold = prices[0];

        for (int i = 1; i < n; i++) {
            int prevCash = cash;
            cash = Math.max(cash, prices[i] - hold - fee);
            hold = Math.min(hold, prices[i] - prevCash);
        }

        return cash;
    }
}