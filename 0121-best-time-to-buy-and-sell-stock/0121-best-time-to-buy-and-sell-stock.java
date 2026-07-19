class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int max  = 0;
        for(int i = 0;i<n;i++){
            if(prices[i] < buy){
                buy = prices[i];
            }
            int profit = prices[i] - buy;
            if(profit>max){
                max = profit;
            }
        }
        return max;
    }
}