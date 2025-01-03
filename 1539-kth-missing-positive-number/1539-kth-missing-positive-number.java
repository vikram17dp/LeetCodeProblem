class Solution { // tc is O(n) and sc is O(1) and optimal sloution
    public int findKthPositive(int[] arr, int k) {
        int low = 0,high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            // it tells about the previous missing numbers
            int missing = arr[mid]-(mid+1);
            if(missing < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high + 1 + k; // return low + k;
    }
}