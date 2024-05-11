public class Solution{
    public int[] twoSum(int[] nums,int target){
    int[] ans = new int[2]; // it will store the index which they have the sum of the two numbers in the indexes
        for(int i =0;i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                   ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}