class Solution {
    public int search(int[] nums, int target) {
        int index =-1;
        int low = 0;
        int high = nums.length -1;
        while(low<=high){
            int mid = low+ (high-low)/2;
             if(nums[mid] == target){
                return  mid;
            } 
            // left sort
            if(nums[low] <= nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            // right sort 
            if(nums[mid] <= nums[high]){
                if(nums[mid]<=target && target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return index;
    }
}