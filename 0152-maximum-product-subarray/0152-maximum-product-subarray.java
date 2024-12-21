class Solution {
    public int maxProduct(int[] nums) {
        int min  = nums[0],max = nums[0],n = nums.length,result = max;
      
        for(int i = 1;i<n;i++){
            int curr = nums[i];
            
            int newMax = Math.max(curr,Math.max(max*curr,min*curr));
            min = Math.min(curr,Math.min(max*curr,min*curr));
            max = newMax;
            result = Math.max(result,max);
        }
        return result;
        
        
       
    }
}