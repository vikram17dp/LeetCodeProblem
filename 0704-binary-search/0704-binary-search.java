class Solution { // TC is O(logn) and sc is Logn for stack space
    public int search(int[] nums, int target) { 
        int n = nums.length;
        return binarySearch(nums,0,n-1,target);
    }
    int binarySearch(int[] nums,int low,int high,int target){
        if(low>high) return -1;
        int mid = low + (high - low) /2;
        if(nums[mid] == target) return mid;
        if(target < nums[mid]){
           return binarySearch(nums,low,mid-1,target);
        }
        return binarySearch(nums,mid+1,high,target);
    }
}
