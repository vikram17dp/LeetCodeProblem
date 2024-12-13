class Solution { // tc is O(n) and sc is O(1)
    public int findClosestNumber(int[] nums) {
        int closest = Integer.MAX_VALUE;
        for(int num:nums){
        if(Math.abs(num) < Math.abs(closest) || (Math.abs(num) == Math.abs(closest) && num>closest)){
               closest = num;
           }
        }
        return closest;
        
    }
}