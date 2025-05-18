class Solution { // tc is O(n)  and sc is O(n - k + 1)
    public int[] maxSlidingWindow(int[] nums, int k) {
       if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0;i< n;i++){
           // remove the element from the front
           if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();;
           }
           //  // Remove smaller elements from back
           while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
           }
           // Add current index
            dq.offerLast(i);

            // Window starts from i >= k - 1
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}