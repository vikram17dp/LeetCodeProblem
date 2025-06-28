class Solution { // tc O(N) and sc is O(1)
    public int findMaxConsecutiveOnes(int[] nums) {// two pointer/sliding window
       int n = nums.length;
       int maxCount = 0;

       int left = 0;

       while(left < n){
            if(nums[left] == 0){
                left++;
                continue;
            }

            int right = left;

            while(right < n && nums[right] == 1){
                right++;
            }
            maxCount = Math.max(maxCount,right-left);
            left = right;
       }
       return maxCount;
        
    }
}