class Solution {// tc is O((log(sum-max))) + O(n) => o(nlog(sum-max)) and sc is O(1)
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int result = high;

        while(low<=high){
            int mid = low + (high - low) /2;

            if(isPossible(nums,n,k,mid)){
                result= mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] nums,int n,int k,int maxSplit){
        int splits = 1;
        int currentSum = 0;

        for(int i =0;i<n;i++){
            if(currentSum + nums[i] > maxSplit){
                splits++;
                currentSum = nums[i];
                if(splits > k) return false;
            }else{
                currentSum += nums[i];
            }
        }
        return true;
    }
}