class Solution { // tc is O(n) and sc is O(n)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> freqMap = new HashMap<>();

        int n = nums.length;
        int threshold = n/3;

        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            if(entry.getValue() > threshold){
                result.add(entry.getKey());
            }
        }        
        return result;
    }
}