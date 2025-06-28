class Solution { // O(N) and O(N)
    public int singleNumber(int[] nums) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num:nums){
            if(map.get(num) == 1){
                return num;
            }

        }
        return -1;
        
        
        
    }
    
}