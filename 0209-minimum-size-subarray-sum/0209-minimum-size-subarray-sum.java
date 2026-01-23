class Solution {// tc is o(n) and sc is O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0;right<n;right++){
            sum += nums[right];

            // sum & tagert part comes
            while(sum >= target){
                minLen = Math.min(minLen,right-left+1);
                sum -= nums[left]; // shrink if gets greater
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}