class Solution {
    public int missingNumber(int[] nums) { // TC is O(N) and SC is O(1)
        int n = nums.length;
        // optimal 1
//         int sum = n*(n+1)/2;
//         int s2 = 0;
        
//         for(int i = 0 ; i<n ; i++){
//             s2 += nums[i];
//         }
//         return (sum-s2);
        
// optimal 2
        int xor1 = 0;
        int xor2 = 0;
        for(int i=0;i<=n;i++){
           xor1 =  xor1^i;
        }
        for(int i = 0;i<n;i++){
          xor2 =  xor2^nums[i];
        }
        return xor1^xor2;
    }
    
}