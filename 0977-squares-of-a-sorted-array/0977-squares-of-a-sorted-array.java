class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int start=0;
        int end = nums.length-1;
        int ptr = ans.length-1;
        while(start<=end){
           int st = nums[start]*nums[start];
            int es = nums[end]*nums[end];
            if(st>es){
                ans[ptr] = st;
                start++;
            }else{
                ans[ptr] = es;
                end--;
            }
            ptr--;
        }
        return ans;
    }
}