class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
         int n = nums.size(),maxLength = 0 ,right = 0,left =0,zeroCount = 0;
        
        while(right < n){
            if(nums[right] == 0){
                zeroCount++;
            }
            
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxLength = max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
};