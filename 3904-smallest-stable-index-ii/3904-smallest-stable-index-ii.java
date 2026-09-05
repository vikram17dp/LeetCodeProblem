class Solution { // tc is O(n) and sc is O(2n)=> o(n) pattern is prefixSum
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for(int i = 1;i<n;i++){
            prefixMax[i] = Math.max(prefixMax[i-1],nums[i]);
        }

        suffixMin[n-1] = nums[n-1];
        for(int i = n-2;i>= 0;i--){
            suffixMin[i] = Math.min(suffixMin[i+1],nums[i]);
        }

        // calculate instablity
        for(int i = 0;i<n;i++){
            int score = prefixMax[i] - suffixMin[i];
            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}