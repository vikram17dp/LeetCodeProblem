class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size(),newmin = nums[0],newmax = nums[0],result = newmax;
        
        for(int i = 1;i<n;i++){
            int curr = nums[i];
            
            int newMax = max(curr,max(newmax*curr,newmin*curr));
            newmin = min(curr,min(newmax*curr,newmin*curr));
            newmax = newMax;
            result = max(result,newmax);
        }
        return result;
    }
};