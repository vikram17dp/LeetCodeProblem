class Solution { // tc is O(nlogn + mlogm) and sc is O(n)
// sorting O(nlogn) and prefix sum is O(n) and bs operation is O(mlogm)
    private int binarySearch(int[] prefix,int target){
        int low = 0,high = prefix.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(prefix[mid] <= target){
                low = mid+1;
            }else{
                high  = mid-1;
            }
        }
        return low;
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length,m = queries.length;

        int[] prefix = new int[n];
        int[] answer = new int[m];

        prefix[0] = nums[0];
        // compute the prefix count
        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        // return the length using bs

        for(int i = 0;i<m;i++){
            int query = queries[i];
            int index = binarySearch(prefix,query);
            answer[i]=index;
        }

    return answer;
    }
}