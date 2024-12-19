class Solution { // tc is O(n) and sc is O(1)
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int startIdx = 0,endIdx=k,sum =0;
        for(int i= 0;i<k;i++)
            sum += nums[i];
        
        int maxAvg = sum;
        
        while(endIdx < n){
            // remove the start element
            sum -= nums[startIdx];
            startIdx++;
            
            // add the new element
            sum += nums[endIdx];
            endIdx++;
            
            maxAvg = Math.max(maxAvg,sum);
            
        }
        return (double) maxAvg / k;
    }
}