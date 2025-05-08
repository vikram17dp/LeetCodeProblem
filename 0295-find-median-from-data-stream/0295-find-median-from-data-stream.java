class MedianFinder {

    private PriorityQueue<Integer> maxHeap;// left & smaller elements
    private PriorityQueue<Integer> minHeap;// right & larger elements

    public MedianFinder() { // tc is O(1) and sc is O(N)
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) { // tc is O(logn)
        // step1:add to maxHeap
        maxHeap.add(num);

        // step2:balance the minHeap
        minHeap.add(maxHeap.poll());

        // step3: maintain size property
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() { // tc is O(1)
        // checking if size is even, then median
        if(maxHeap.size() == minHeap.size()){
            return(maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */