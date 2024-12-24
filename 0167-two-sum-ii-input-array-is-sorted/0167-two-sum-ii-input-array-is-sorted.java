class Solution { // tc is O(nsquare) and sc is O(1)
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        
        int left = 0,right = n-1;
        
        while(left<right){
            int sum = numbers[left] + numbers[right];
            
            if(sum == target){
                return new int[] {left+1,right+1};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        
        return null;
    }
}