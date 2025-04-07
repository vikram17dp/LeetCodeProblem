class Solution { // tc is O(n) and sc is O(1)
    public int jump(int[] nums) {
        int end = 0,jumps = 0,farthest = 0;

        for(int i = 0;i<nums.length-1;i++){
            farthest = Math.max(farthest,i+nums[i]);
            if(i == end){
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}