class Solution {
    public int missingNumber(int[] nums) { // TC is O(N) and SC is O(1)
        int n = nums.length;
        
        int expectedSum = n * (n+1)/2;
        int actualSum = 0;

        for(int num:nums){
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
    
}