class Solution { // O(N) & O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // step1 reverse full array
        reverse(nums,0,n-1);
        // step2 reverse the k numbers of arrays
        reverse(nums,0,k-1);
        // step3 reverse the index from k to n-1 arrays
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums,int start,int end){
            while(start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

}