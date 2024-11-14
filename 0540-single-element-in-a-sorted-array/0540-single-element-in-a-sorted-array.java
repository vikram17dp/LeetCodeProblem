class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        // Handle edge cases
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        
        // Binary search for the single element
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check bounds before accessing adjacent elements
            if ((mid == 0 || nums[mid] != nums[mid - 1]) && 
                (mid == n - 1 || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }
            
            // Determine which side to search based on the pairing pattern
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || 
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1; // Move to the right side
            } else {
                high = mid - 1; // Move to the left side
            }
        }
        
        return -1; // Return -1 if no single element is found
    }
}
