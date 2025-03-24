class Solution { // tc is O(N+M) and sc is O(1)
    public int getCommon(int[] nums1, int[] nums2) {
        for(int num:nums1){
            if(binarySearch(nums2,num)){
                return num;
            }
        }
        return -1;
    }

    public boolean binarySearch(int[] arr,int target){
        int left = 0,right = arr.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}