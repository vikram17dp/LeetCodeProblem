class Solution { // tc is O(m * n) and sc is O(m*n) dp memoization
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0, 0, s, t,dp);
    }

    int solve(int i, int j, String s, String t, int[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) { // already calculated
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = solve(i + 1, j + 1, s, t, dp) // take
                    + solve(i + 1, j, s, t, dp); // skip
        } else {

            dp[i][j] = solve(i + 1, j, s, t,dp);
        }
        return dp[i][j];
    }
}