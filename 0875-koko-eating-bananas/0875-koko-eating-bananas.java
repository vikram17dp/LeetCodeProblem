class Solution {
    // Helper function to find the maximum number in the array
    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        // Find the maximum:
        for (int i = 0; i < v.length; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    // Helper function to calculate total hours needed with a given speed
    public static long calculateTotalHours(int[] v, int hourly) {
        long totalH = 0;
        // Find total hours:
        for (int pile : v) {
            // Use long to avoid overflow during large pile and speed computation
            totalH += (long) Math.ceil((double) pile / hourly);
        }
        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        int ans = high; // Initialize answer with the maximum possible value
        
        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid-point speed
            long totalHrs = calculateTotalHours(piles, mid);

            // Check if Koko can finish with this speed within h hours
            if (totalHrs <= h) {
                ans = mid; // Update answer to the current feasible speed
                high = mid - 1; // Try to find a smaller speed
            } else {
                low = mid + 1; // Increase speed since current speed is too slow
            }
        }
        return ans;
    }

    
}
