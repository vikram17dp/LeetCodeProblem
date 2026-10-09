class Solution { // o(logn)
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid  = low + (high-low)/2;
            // if search space of array is sorted on that time,no need to perform BS 
            if(nums[low]<=nums[high]){
                ans = Math.min(ans,nums[low]);
                break;
            }
            if(nums[low]<=nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }else{
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}