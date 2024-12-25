class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int goodPair = 0;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(nums[i] == nums[j]){
                    goodPair+=1;
                }
            }
        }
        return goodPair;
    }
}