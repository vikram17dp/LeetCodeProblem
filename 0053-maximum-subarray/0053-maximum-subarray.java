class Solution { // TC is O(n) and SC is O(1)
    public int maxSubArray(int[] nums) {
        int maxsum =nums[0];
        int currentsum = nums[0];
        if(nums.length == 0) return 0;
        for(int i =1;i<nums.length;i++){
            currentsum = Math.max(nums[i],currentsum+nums[i]);
            maxsum = Math.max(currentsum, maxsum);
        }
        return maxsum;
    }
}