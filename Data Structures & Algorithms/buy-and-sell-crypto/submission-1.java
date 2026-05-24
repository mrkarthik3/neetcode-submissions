class Solution {
    public int maxProfit(int[] prices) {
        // O(n) Time and O(1) Space
        // Two pointer
        int n = prices.length;
        int botDay = 0;
        int soldDay = botDay+1;
        int maxProfit = 0;
        while(soldDay <= n-1) {
            int profit = prices[soldDay] - prices[botDay];
            if (profit < 0) {
                botDay++;
                soldDay = botDay+1;
            } else {
                maxProfit = Math.max(profit, maxProfit);
                soldDay++;
            }
        }
        return maxProfit;
    }
}
