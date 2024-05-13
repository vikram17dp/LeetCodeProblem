class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int start =0;
        int end = numbers.length-1;
        while(start<end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                ans[0]= start+1;
                ans[1] = end+1;
                return ans;
            }else if(sum>target){ // if the sum is greater than our target then end move to its left side similary sum is less than target then it will move right side
                end--;
            }else{
                start++;
            }
        }
        return ans;
    }
}