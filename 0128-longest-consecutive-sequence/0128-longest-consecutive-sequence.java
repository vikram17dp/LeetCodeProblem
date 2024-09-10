class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 1;
        int currentLength = 1;
        int n = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for(int i = 1;i<n;i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            else if(nums[i] == nums[i-1]+1){
                currentLength++;
            }else{
                longest = Math.max(longest,currentLength);
                currentLength = 1;
                
            }
            
        }
        
    return Math.max(longest, currentLength);
   
    
    }
}