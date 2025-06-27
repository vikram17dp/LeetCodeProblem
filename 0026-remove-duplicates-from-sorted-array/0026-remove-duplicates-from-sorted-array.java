class Solution {
    public int removeDuplicates(int[] nums) { // TC is O(N) and SC is O(1)
      int n = nums.length;

      if(n == 0) return 0;
      int i = 0;
      for(int j = 1;j<n;j++){
        if(nums[j] != nums[i]){
            i++;
            nums[i] = nums[j];
        }
      }
      return i+1;
    }
}