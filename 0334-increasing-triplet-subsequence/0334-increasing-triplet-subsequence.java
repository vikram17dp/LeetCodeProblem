class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE; // it means +infinity
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            int ele = nums[i]; // like 1 2 3 4 5 like that here store
            if(first>=ele){ // +infinty >= 1 true only the value updated
                first = ele;
                
            }else if(second>=ele){
                second = ele;
            }else{
                third = ele;
                return true;
            }
        }
        return false;
        
    }
}