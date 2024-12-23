class Solution { // tc is O(n+m)+O(n+m) and sc is O(n+m)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[n+m];
        int left = 0,right = 0,index = 0;
        // merging step
        while(left <m && right <n){
            if(nums1[left] <= nums2[right]){
                nums3[index] = nums1[left];      
                left++;
                index++;
            }else{
                nums3[index] = nums2[right];
                right++;
                index++;
            }
        }
        
        // extra element in left
        while(left < m){
            nums3[index++] = nums1[left++];
        }
        // extra element in right
        
        while(right < n){
            nums3[index++] = nums2[right++];
        }
        
        // store back the ele into original arr
        
        for(int i = 0;i<m+n;i++){
            nums1[i] = nums3[i];    
        }
    }
}