class Solution { // tc is O(mn) and sc is O(mn) stack space
    // we are solving this using dp memoization techcinque becuase it solves the overlapping subproblems
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return costPaths(m - 1, n - 1, dp);
    }

    int costPaths(int row, int col, int[][] dp) {
        if (row == 0 || col == 0)
            return 1;
        if (dp[row][col] != 0)
            return dp[row][col];
        dp[row][col] = costPaths(row - 1, col, dp) + costPaths(row, col - 1, dp);
        return dp[row][col];
    }
}