class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        List<Integer>[] bucket = new List[nums.length+1]; // bucket list
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        
        for(int n:nums){ 
            // adding into the frequencyMap 
            frequencyMap.put(n,frequencyMap.getOrDefault(n,0)+1);
        }
        
        for(int key : frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        int[] res = new int[k];
        int counter = 0;
        
        for(int pos = nums.length;pos>=0 && counter<k;pos--){
            if(bucket[pos] != null){
                for(Integer integer:bucket[pos]){
                    res[counter++] = integer;
                }
            }
        }
        return res;
    }
}