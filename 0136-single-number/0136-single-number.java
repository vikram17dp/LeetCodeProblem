class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i =0;i<n;i++){
           int num = nums[i];
            count = 0;
            for(int j =0;j<n;j++){
                if(nums[j] == num){
                    count++;
                }
            }
            if(count == 1) return num;
        }
        throw new IllegalArgumentException("No single number found");
        
    }
    
}