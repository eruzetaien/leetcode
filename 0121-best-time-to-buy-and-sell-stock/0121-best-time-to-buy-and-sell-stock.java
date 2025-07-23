class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++){
            int currentProfit = prices[i] - buyPrice;
            if (currentProfit > maxProfit){maxProfit = currentProfit;}

            if (prices[i] < buyPrice){buyPrice = prices[i];}
        }

        return maxProfit;
    }
}