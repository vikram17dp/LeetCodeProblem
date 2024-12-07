class Solution { // tc is O(n) and sc is O(1)
public:
    int maxProfit(vector<int>& prices) {
       int buy_price = INT_MAX,sell_price = 0,maxprofit =0;
        
        for(int price : prices){
            
            buy_price = min(buy_price,price);
            
            int current_profit = price - buy_price;
            
            if(current_profit >maxprofit){
                maxprofit = current_profit;
                sell_price = price;
            }
            
        }
        return maxprofit;
     
    }
};