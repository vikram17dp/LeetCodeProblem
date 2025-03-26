class Solution { // tc is O(NlogM) and sc is O(n)
    private boolean binarySearch(int[] arr,int target){
        int low = 0,high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low) /2;

            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);

        Set<Integer> resultSet = new HashSet<>();

        for(int num:nums1){
            if(binarySearch(nums2,num)){
                resultSet.add(num);
            }
        }

        int[] result  = new int[resultSet.size()];
        int i =0;
        for(int num:resultSet){
            result[i++] = num;
        }
        return result;
    }
}