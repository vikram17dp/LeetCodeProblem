Brute force
class Solution {
public:
int maxProfit(vector<int>& prices) {
int n = prices.size(),maxProfit = 0;
for(int i =0;i<n;++i){
for(int j = i+1;j<n;++j){
int profit = prices[j]-prices[i];
maxProfit = max(maxProfit,profit);
}
}
return maxProfit;
}
};