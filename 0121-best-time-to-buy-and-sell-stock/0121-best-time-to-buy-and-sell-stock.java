class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 0){ 
            return 0;
        }
        return getMaxProfit(prices);
    }
     private int getMaxProfit(int[] prices) {
         
        int minStockPrice = Integer.MAX_VALUE;
        int maxDiff = 0;
        
         for(int i = 0; i < prices.length; i++) {
            int earn =  prices[i] - minStockPrice;
            maxDiff = Math.max(earn, maxDiff);
            minStockPrice = Math.min(minStockPrice, prices[i]);
        }
         
        return maxDiff;
    }
}