class Solution {
    public int[] searchRange(int[] nums, int target) { // TC => O(logn)
        int[] ans = {-1,-1};
        if(nums.length == 0){ // if the number length is zero then it will -1,-1
            return ans;
        }
        ans[0]=FirstOcurrance(nums,target); 
        // if only when one index is their on that it will call same as next one 
        ans[1]=LastOcuurance(nums,target);
        return ans;
       
    }
    public int FirstOcurrance(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                ans = mid;
                end = mid-1;
            }else if(target>nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }  
        }
        return ans;
       
    }
    public int LastOcuurance(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start<=end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                ans = mid;
                start = mid+1;
            }else if(target> nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
}