class Solution {// tc is O((log(sum-max))) + O(n) => o(nlog(sum-max)) and sc is O(1)
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        for(int num:nums){
            max = Math.max(max,num);
            sum += num;
        }
        int low = max;
        int high = sum;
        int result = sum;

        while(low<=high){
            int mid = low + (high - low) /2;                                                        

            if(canSplit(nums,k,mid)){
                result= mid;
                high = mid-1; // try for smaller
            }else{
                low = mid+1; // try for bigger
            }
        }
        return result;
    }

    private boolean canSplit(int[] nums,int k,int maxSum){
        int splits = 1;
        int currentSum = 0;

        for(int num:nums){
            if(currentSum + num > maxSum){
                splits++;
                currentSum = num;
                
            }else{
                currentSum += num;
            }
        }
        return splits <= k;
    }
}