class Solution { // tc is O(n) and sc is O(1)
    public int maxAbsoluteSum(int[] nums) {
        // If problem says “maximum absolute”, always track BOTH maximum and minimum.
        int currMax = 0, maxSum = 0;
        int currMin = 0, minSum = 0;

        for (int num : nums) {
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }
        return Math.max(maxSum, Math.abs(minSum));
    }
}