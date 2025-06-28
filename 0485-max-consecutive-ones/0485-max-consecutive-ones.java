class Solution { // tc O(N) and sc is O(1)
    public int findMaxConsecutiveOnes(int[] nums) {// two pointer/sliding window
       int n = nums.length;
       int max = 0;
       int count = 0;

       for(int i = 0;i<n;i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;
            }
       }
       return max;
    }
}