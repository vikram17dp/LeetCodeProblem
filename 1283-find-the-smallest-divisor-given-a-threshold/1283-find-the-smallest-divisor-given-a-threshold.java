class Solution { // tc is O(log(max)N) and sc is O(1)
    private int sumofD(int[] arr,int divisor){
        int sum =0,n = arr.length;
        for(int i =0;i<n;i++){
            sum += (int)Math.ceil((double)arr[i]/divisor);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
       int low = 1,high = Integer.MIN_VALUE,ans = -1;
         // Find the maximum element in nums to set 'high'
        for(int i =0;i<nums.length;i++){
            high = Math.max(high,nums[i]);
        }
       while(low<=high){
           int mid = low + (high-low)/2;
           if(sumofD(nums,mid)<=threshold){
               ans = mid;
               high = mid-1; // move to left
           }else{
               low = mid+1; // move to right
           }
       }
        return ans;
    }
}