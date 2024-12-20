class Solution { // tc is O(nsquare) and sc is O(1)
    public int longestOnes(int[] nums, int k) {
        int n = nums.length,maxLength = 0;
        
        for(int i =0;i<n;i++){
             int zeroCount = 0;
            for(int j = i;j<n;j++){
               
                if(nums[j] == 0){
                    zeroCount++;
                }
                if(zeroCount <= k){
                    maxLength = Math.max(maxLength,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxLength;
    }
}