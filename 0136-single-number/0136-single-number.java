class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        
        for(int num:hash.keySet()){
            if(hash.get(num) == 1){
                return num;
            }
        }
        throw new IllegalArgumentException("No single number found");
        
    }
    
}