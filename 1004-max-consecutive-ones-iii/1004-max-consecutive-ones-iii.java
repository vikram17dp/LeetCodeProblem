class Solution { // tc is O(n) and sc is O(1)
    public int longestOnes(int[] nums, int k) {
        int n = nums.length,maxLength = 0 ,right = 0,left =0,zeroCount = 0;
        
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
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}