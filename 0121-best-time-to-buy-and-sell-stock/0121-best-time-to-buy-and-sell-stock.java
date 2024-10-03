class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE; // track the minimum price so far

        // Iterate through the prices array
        for (int price : prices) {
            // Update the minimum price (buy) if we find a lower price
            if (price < buy) {
                buy = price;
            }
            // Calculate the potential profit if we sell at the current price
            int currentProfit = price - buy;
            
            // Update profit if the current calculated profit is greater
            profit = Math.max(profit, currentProfit);
        }

        return profit;
    }
}