class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        result[0] = findFirst(nums,target);
        result[1] = findLast(nums,target);
        return result;
    }
    public int findFirst(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int index = -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>=target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            if(nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
    public int findLast(int[] nums,int target){
        int low= 0;
        int  high = nums.length-1;
        int index = -1;
        while(low<= high){
                int mid = low + (high-low)/2;
            if(nums[mid]<= target){
                low = mid+1;
            }else{
                high = mid-1;
            }
            if(nums[mid] == target){
                index = mid;
            }
            
        }
        return index;
    }
}