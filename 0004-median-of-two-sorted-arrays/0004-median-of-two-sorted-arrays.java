import java.util.ArrayList;
import java.util.List;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> nums3 = new ArrayList<>();
        int i = 0,j = 0;
          while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                nums3.add(nums1[i++]);
            } else {
                nums3.add(nums2[j++]);
            }
        }
        while(i<n1)  nums3.add(nums1[i++]);
        while(j<n2)  nums3.add(nums2[j++]);
        int n = nums3.size();
        if(n % 2 == 1){
            return nums3.get(n/2);
        }else{
            return (nums3.get(n/2) + nums3.get(n/2-1))/2.0;
        }
    }
}