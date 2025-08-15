class Solution { // tc is O(n) and sc is O(1)
    public int maxProduct(int[] nums) {
       
       int max = nums[0],min = nums[0],n = nums.length,result = max;

       for(int i = 1;i<n;i++){
            int curr = nums[i];
            int newMax = Math.max(curr,Math.max(max * curr,min*curr));
            min = Math.min(curr,Math.min(max*curr,min*curr));
            max = newMax;

            result = Math.max(max,result);
       }
       return result;
    }
}