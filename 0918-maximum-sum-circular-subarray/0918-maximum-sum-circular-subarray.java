class Solution { // tc is O(n) and sc is O(1)
    public int maxSubarraySumCircular(int[] nums) {
        // it is not same as kadanes algo,but we have to caluclate both maximum subarraysum + minimum subarraysum 

        int n = nums.length;

        int totalSum = nums[0];
        int currMax = nums[0],maxSum = nums[0];
        int currMin = nums[0],minSum = nums[0];

        for(int i = 1;i<n;i++){
            totalSum += nums[i];

            currMax = Math.max(nums[i],currMax+nums[i]);
            maxSum = Math.max(maxSum,currMax);

            currMin = Math.min(nums[i],currMin + nums[i]);
            minSum = Math.min(minSum,currMin);
        }

        if(totalSum == minSum){
            return maxSum;// all negative values
        }
        return Math.max(maxSum,totalSum-minSum);
    }
}