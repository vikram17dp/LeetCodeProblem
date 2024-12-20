class Solution { // tc is O(n) and sc is O(1)
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count =0,right =0,left =0;
           int odd = 0;
        
        while(right < n){
         
            if(nums[right] % 2 != 0){
                odd++;      
            }
            // shrink step
            while(odd > k){
                if(nums[left] %2 != 0){
                    odd--;
                }
                left++;
            }
            
            if(odd == k){
                count++;
                int tempLeft = left;
                
                while(tempLeft<right && nums[tempLeft] % 2 == 0){
                    count++;
                    tempLeft++;
                }
            }
            
            
            right++;
           
        }
        return count;
    }
}