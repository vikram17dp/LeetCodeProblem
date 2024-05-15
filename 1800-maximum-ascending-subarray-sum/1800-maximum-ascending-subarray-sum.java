class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int currmax = nums[0];
        for(int i =1;i<nums.length;i++){ // it runs i index from index 1
            if(nums[i-1]<nums[i]){ // this one checking the last index
                currmax = currmax + nums[i];
                
            }else{
                max = Math.max(max,currmax);
                currmax= nums[i];
            }
        }
        max = Math.max(max,currmax); // in this one it will taken the max and return that one
        return max;
    }
}