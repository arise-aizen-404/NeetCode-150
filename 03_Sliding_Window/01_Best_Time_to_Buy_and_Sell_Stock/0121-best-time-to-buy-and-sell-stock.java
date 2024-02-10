class Solution {
    public int maxProfit(int[] prices) {
        int min_value = Integer.MAX_VALUE;
        int max_profit = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;++i) {
            min_value = Math.min(min_value, prices[i]);
            max_profit = Math.max(max_profit, (prices[i]-min_value));
        }
        return max_profit;
    }
}