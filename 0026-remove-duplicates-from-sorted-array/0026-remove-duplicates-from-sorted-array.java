class Solution {
    public int removeDuplicates(int[] nums) { // TC is O(N) and SC is O(1)
       int i = 0;
        for(int j = 1;j<nums.length;j++){ // j =  or j = 1
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}