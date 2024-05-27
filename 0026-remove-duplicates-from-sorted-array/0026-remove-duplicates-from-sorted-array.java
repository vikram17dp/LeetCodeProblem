class Solution {
    public int removeDuplicates(int[] nums) {
    int rd = 1;
     
        for(int i =0;i<nums.length-1;i++){
     
            if( nums[i]!=nums[i+1]){
           
                nums[rd] = nums[i+1];
                rd++;
            }
        }   
        return rd;
    }
}