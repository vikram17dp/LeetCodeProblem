class Solution { // tc is O(n) and sc is O(n) pattern is prefix sum -> we can do it in + and -ve values as well 
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int n = nums.length;
        int sum = 0;
        // base condition
        map.put(0,1);
        
        for(int num:nums){
            sum += num;
            if(map.containsKey(sum-k)){
                count+= map.get(sum-k);
            }   
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}