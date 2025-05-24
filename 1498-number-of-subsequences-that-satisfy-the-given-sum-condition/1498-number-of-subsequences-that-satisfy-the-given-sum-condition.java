class Solution { // tc is o(nlogn) and sc is O(n)
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);

        int[] pow = new int[n];
        pow[0] = 1;
        // precompute powers of 2 modulo mod
        for(int i = 1;i<n;i++){
             pow[i] = (pow[i - 1] * 2) % mod;
        }
        int left = 0,right = n-1,count = 0;

        while(left <= right){
            if(nums[left] + nums[right] <= target){
                count = (count+ pow[right-left]) % mod;
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}