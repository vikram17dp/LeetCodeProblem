class Solution { // tc is O(n) and sc is O(1)
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int windowSum = 0;

        for(int i = 0;i<k;i++){
            windowSum += nums[i];
        }

        int maxAvg = windowSum;

        for(int end = k;end<n;end++){
            windowSum += nums[end];// adding the next element
            windowSum -= nums[end-k]; // remove the previous element
            maxAvg = Math.max(maxAvg,windowSum);
        }
        
        
        return (double) maxAvg / k;
    }
}