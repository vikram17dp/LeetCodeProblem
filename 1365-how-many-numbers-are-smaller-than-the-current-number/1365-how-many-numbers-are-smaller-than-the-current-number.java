class Solution { // tc is O(n) and sc is O(1)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
      
        int[] buckets = new int[102];
        
        // get the frequency of elements
        for(int num:nums){
            buckets[num]++;
        }
        
        // get buckets[i] += buckets[i-1]
        
        for(int i = 1;i<buckets.length;i++){
            buckets[i] += buckets[i-1];
        }
        
        int[] result = new int[n];
        for(int i = 0;i<result.length;i++){
            if(nums[i] == 0){
                result[i] = 0;
            }else{
                result[i] = buckets[nums[i]-1];
            }
        }
        
        return result;
        
    }
}