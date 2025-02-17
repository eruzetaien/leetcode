class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <=1){
            return 0;
        }

        int buyPrice = prices[0];
        int currentProfit = 0;
        int currentSellPrice= 0;
        int pointer= 1;

        int totalProfit = 0;

        while (pointer < prices.length){
            int currentPrice = prices[pointer];
            int profit = currentPrice  - buyPrice;

            if (profit < 0 && currentSellPrice == 0) {
                buyPrice = currentPrice;
            } else if (profit > currentProfit){
                currentProfit = profit;
                currentSellPrice = currentPrice;
            } else { // profit <= currentProfit
                totalProfit += currentProfit;
                currentProfit =0;
                currentSellPrice=0;
                buyPrice = currentPrice;
            }
            pointer++;
        }
        totalProfit += currentProfit;
        return totalProfit;
    }
}