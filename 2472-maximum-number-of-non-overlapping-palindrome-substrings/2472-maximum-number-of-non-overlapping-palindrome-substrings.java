class Solution { // tc and sc is O(n Square)

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // palindrome[i][j] = true
        // if s[i...j] is a palindrome
        boolean[][] palindrome = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)
                        && (j - i < 2 || palindrome[i + 1][j - 1])) {

                    palindrome[i][j] = true;
                }
            }
        }

        // dp[i] = maximum number of valid palindromes
        // we can select starting from index i
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            // Skip current position
            dp[i] = dp[i + 1];

            // Try taking a palindrome
            for (int j = i + k - 1; j < n; j++) {

                if (palindrome[i][j]) {

                    dp[i] = Math.max(
                            dp[i],
                            1 + dp[j + 1]
                    );
                }
            }
        }

        return dp[0];
    }
}