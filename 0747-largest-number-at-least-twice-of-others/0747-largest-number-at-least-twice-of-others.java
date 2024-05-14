class Solution {
    public int dominantIndex(int[] nums) {
      int max = -1;
      int smax = -1;
      int maxIdx = 0;
        for(int i=0;i<nums.length;i++){
            // for ex 6<6 is also false here
            if(max < nums[i]){
            smax = max;
            max = nums[i];
            maxIdx=i;
         }else if(smax < nums[i]){
            smax = nums[i];
        }
        }
        if(2*smax <= max){
            return maxIdx;
        }else{
            return -1;
        }
        
    }
}