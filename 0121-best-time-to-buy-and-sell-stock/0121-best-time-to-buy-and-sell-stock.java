class Solution {// tc is O(n) and sc is O(1)
    public int maxProfit(int[] prices) {
       int minPrice = Integer.MAX_VALUE;
       int maxProfit = 0;

       for(int price:prices){
         minPrice = Math.min(price,minPrice);
         int profit = price - minPrice;
         maxProfit = Math.max(profit,maxProfit);
       }
       return maxProfit;
    }
}