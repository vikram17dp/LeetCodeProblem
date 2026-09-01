class Solution {// tc is O(n) and sc is O(1)
    public int climbStairs(int n) {
        // if(n == 1) return 1;
        // if(n == 2) return 2;
        if(n <= 2) return n;
        int prev1 = 1;
        int prev2 = 2;
        
        for(int i = 3;i<=n;i++){
            int current = prev1+prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }
}