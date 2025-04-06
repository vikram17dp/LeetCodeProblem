class Solution { // tc is O(n) and sc is O(1)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest  = 0;

        for(int i = 0;i<=farthest ;i++){
            farthest = Math.max(farthest , i+nums[i]);
            if(farthest >= n-1) return true;
        }
        return false;
    }
}