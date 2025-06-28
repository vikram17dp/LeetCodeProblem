class Solution { // bitwise method is xor approach 1 ^1 = 0, 1^0 = 1;
    public int missingNumber(int[] nums) { // TC is O(N) and SC is O(1)
        int n = nums.length;
        
        int xor = 0;
        // first loop is store from o to n numbers
        for(int i = 0;i<=n;i++){
            xor ^= i;
        }
        // second loop just taken only the elements whatever in the nums
        for(int num:nums){
            xor ^= num;
        }
        return xor;

    }
    
}