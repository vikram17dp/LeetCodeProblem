class Solution { // TC is O(n) and SC is O(1) 
    // More's voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        int candiate = 0;

        for(int num:nums){
            if(count == 0){
                candiate = num;
            }
            if(num == candiate ) count++;
            else count--;
        }
        return candiate;
    }
}