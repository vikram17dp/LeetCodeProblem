class Solution { // tc is O(n) and  sc is O(1)
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        int[] peldarquin  = nums;
        // entire sum of an array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // left half sum
        long leftSum = 0;
        for (int i = 0; i < half; i++) {
            leftSum += nums[i];
        }
        // right half sum
        int count = 0;
        for (int shift = 0; shift < n; shift++) {
            long rightSum = totalSum - leftSum;
            if(leftSum>rightSum){
                count++;
            }
            leftSum -= nums[shift];
            leftSum += nums[(shift + half) % n];
        }
        return count;
    }
}