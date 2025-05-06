class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) { // tc is o(nlognK) and sc is O(n)
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int num:nums){
            add(num);
        }
    }
    
    public int add(int val) { // tc is O(logn) and sc is o(N)
        minHeap.offer(val);
        if(minHeap.size() > k){
            minHeap.poll(); // remove smallest to maintain k size
        }
    return minHeap.peek(); // kth largest
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */