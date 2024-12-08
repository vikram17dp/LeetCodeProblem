class Solution {
    public int[] sortedSquares(int[] nums) { // tc is o(n) and sc is O(n)
        int n = nums.length;
        int result[] = new int[n];
        
        int head = 0;
        int tail = nums.length-1;
        
        for(int i = 0;i<n;i++){
            nums[i] = nums[i] * nums[i];
        }
        
        for(int pos = tail;pos>=0;pos--){
            if(nums[head]>nums[tail]){
                result[pos] = nums[head];
                head++;
            }else{
                result[pos] = nums[tail];
                tail--;
            }
        }
        
        return result;
    }
}