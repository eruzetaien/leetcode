class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <=1){
            return 0;
        }

        int buyPrice = prices[0];
        int currentProfit = 0;
        int sellIndex= 1;

        while (sellIndex < prices.length){
            int profit =  prices[sellIndex] - buyPrice;

            if (profit < 0) {
                buyPrice = prices[sellIndex];
            } else if (profit > currentProfit){
                currentProfit = profit;
            }
            sellIndex++;
        }
        return currentProfit;
    }
}