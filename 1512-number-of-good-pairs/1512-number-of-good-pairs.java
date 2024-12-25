class Solution { // tc is O(n) and sc is O(102)
    public int numIdenticalPairs(int[] nums) {
        // storing the freq of numbers
        int[] count = new int[102];
        
        for(int num:nums){
            count[num]++;
        }
        
        int totalCount = 0;
        
        for(int i:count){
            totalCount += ((i) * (i-1)/2);
        }
        return totalCount;
        
        
    }
}