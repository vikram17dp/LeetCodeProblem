class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int square[] = new int[n];
        for(int i = 0;i<n;i++){
             square[i] = nums[i] * nums[i];
        }
        Arrays.sort(square);
        return square;
    }
}