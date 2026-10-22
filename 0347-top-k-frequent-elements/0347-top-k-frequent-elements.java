class Solution { // tc is O(n+mlogm) and sc is O(n+m)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        
        for(int num:map.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for(int i = 0;i<k;i++){
            result[i] = minHeap.poll();
        }
        return result;
    }
}