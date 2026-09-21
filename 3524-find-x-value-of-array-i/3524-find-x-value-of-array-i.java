class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] newDp = new long[k];

            int rem = num % k;

            // Start a new subarray
            newDp[rem]++;

            // Extend previous subarrays
            for (int oldRem = 0; oldRem < k; oldRem++) {
                if (dp[oldRem] > 0) {
                    int newRem = (oldRem * rem) % k;
                    newDp[newRem] += dp[oldRem];
                }
            }

            // Add subarrays ending at current position
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
}