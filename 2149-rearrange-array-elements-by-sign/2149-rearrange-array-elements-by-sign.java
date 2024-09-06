class Solution {
    public int[] rearrangeArray(int[] nums) { // TC is O(n) and SC is O(n)
        int n = nums.length;
        int posIndex = 0, negIndex = 1;
        int result[] = new int[n];
        // for(int i =0;i<n;i++){
        //     if(nums[i]<0){
        //         result[negIndex] = nums[i];
        //         negIndex +=2;
        //     }else{
        //         result[posIndex] = nums[i];
        //         posIndex +=2;
        //     }
        // }
        for(int num:nums){
            if(num<0){
                result[negIndex] = num;
                negIndex +=2;
            }else{
                result[posIndex] = num;
                posIndex +=2;
            }
        }
        return result;
        
    }
}