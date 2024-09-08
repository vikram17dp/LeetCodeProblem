class Solution {
    public boolean check(int[] nums) { // O(N) and O(1)
        int countbreak = 0;
        for(int i = 0 ;i<nums.length;i++){
            
            if(nums[i] > nums[(i+1) % nums.length]) countbreak++;
            
            // 5%5 is equal to 0
            
            if(countbreak> 1) return false;
            
        }
        return true;
    }
}