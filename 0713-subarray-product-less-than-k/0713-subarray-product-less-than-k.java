class Solution { // tc is O(N) and sc is O(1) and variable shrinking sliding window
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int product = 1,count = 0,start = 0;
        int n = nums.length;
        if(k<= 1) return 0;

        for(int end = 0;end<n;end++){
            product *= nums[end];

            while(product >= k){
                product /= nums[start]; // undo the first product
                start++;// shrink the window
            }
            count += end-start+1;
        }
        return count;
    }
}