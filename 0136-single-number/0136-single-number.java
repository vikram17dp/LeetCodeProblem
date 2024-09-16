class Solution { // O(N) and O(1)
    public int singleNumber(int[] nums) {
        int n = nums.length;
      int xOr = 0;
        for(int i = 0;i<n;i++){
            xOr = xOr^nums[i];
        }
        return xOr;
        
        
        
    }
    
}