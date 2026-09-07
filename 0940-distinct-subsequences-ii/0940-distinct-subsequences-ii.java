class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1_000_000_007;

        // dp[c] = number of distinct subsequences
        // whose last character is c
        long[] dp = new long[26];

        for (char ch : s.toCharArray()) {

            int idx = ch - 'a';

            long total = 1; // empty subsequence

            for (int i = 0; i < 26; i++) {
                total = (total + dp[i]) % MOD;
            }

            // All existing subsequences + current character
            // become subsequences ending with ch.
            dp[idx] = total;
        }

        long answer = 0;

        for (long count : dp) {
            answer = (answer + count) % MOD;
        }

        return (int) answer;
    }
}