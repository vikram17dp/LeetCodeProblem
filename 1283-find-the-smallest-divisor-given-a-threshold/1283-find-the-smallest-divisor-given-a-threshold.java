class Solution {
    private int sumofD(int[] arr,int divisor){
        int sum =0,n = arr.length;
        for(int i =0;i<n;i++){
            sum += (int)Math.ceil((double)arr[i]/divisor);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
       int low = 1,high = Integer.MIN_VALUE,ans = -1;
        for(int i =0;i<nums.length;i++){
            high = Math.max(high,nums[i]);
        }
       while(low<=high){
           int mid = low + (high-low)/2;
           if(sumofD(nums,mid)<=threshold){
               ans = mid;
               high = mid-1;
           }else{
               low = mid+1;
           }
       }
        return ans;
    }
}