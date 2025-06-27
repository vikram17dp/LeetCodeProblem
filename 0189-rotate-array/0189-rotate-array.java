class Solution { // O(N) & O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        // step1 : reverse the owl array
        reverse(nums,0,n-1);
        // step2: reverse the k elements in an array
        reverse(nums,0,k-1);
        // step3: reverse the n-k arrays means remaining arrays
        reverse(nums,k,n-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}