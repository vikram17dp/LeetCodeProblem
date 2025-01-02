class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr=0;
        for(int i=0;i<nums.length;i++){
// if the nums[i] = val then it will consider as flase then it will comes out if not eqaul then it will return the nums[i] in ana array

            if(nums[i]!=val){
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        return ptr;
       
    }
   
}