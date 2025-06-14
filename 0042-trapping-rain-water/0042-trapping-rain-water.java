class Solution { // tc is O(n) and sc is O(1)
    public int trap(int[] height) {
        int left = 0,right = height.length-1;
        int leftMax = 0,rightMax=0;
        int totalWater = 0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    totalWater += leftMax-height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    totalWater += rightMax-height[right];
                    
                }
                right--;
            }
        }
        return totalWater;
    }
}