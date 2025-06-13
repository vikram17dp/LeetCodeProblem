class Solution { // tc is O(nsquare) and sc is O(n+N×L)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        
        int maxLen = 0;
        for(String word:wordDict){
            maxLen = Math.max(maxLen,word.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        // base case: empty string is valid
        dp[0] = true;

        for(int i = 1;i<=n;i++){
            for(int j = i-1; j>= Math.max(0,i-maxLen);j--){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
    // i need to return the last index if true answer is true otherwise false
    return dp[n];
    }
}