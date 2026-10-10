class Solution { // tc is O(logn ) and sc is O(1)
    public int[] searchRange(int[] nums, int target) {
       int[] result = {-1,-1};
       result[0] = findFirst(nums,target);
       result[1] = findLast(nums,target);
       return result;
    }

    private int findFirst(int[] nums,int target){
        int low = 0,high = nums.length-1;
        int index = -1;

        while(low<=high){
            int mid = low + (high - low) /2;

            if(nums[mid] == target){
                index = mid;
                high = mid-1;// keep for the left
            }else if(nums[mid] >= target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return index;
    }
    private int findLast(int[] nums,int target){
        int low = 0,high = nums.length-1;
        int index = -1;

        while(low<=high){
            int mid = low + (high - low) /2;

            if(nums[mid] == target){
                index = mid;
                low = mid+1;// keep for the right
            }else if(nums[mid] <= target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return index;
    }
    
    
}