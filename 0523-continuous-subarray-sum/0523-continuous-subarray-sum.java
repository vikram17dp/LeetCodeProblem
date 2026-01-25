class Solution {// tc is O(n) and sc is O(n) and prefix sum modulo + hashmap
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);// for oth index having -1, then actualy when we are doing we can consider an oth index as well 

        for(int i = 0;i<n;i++){
            prefixSum += nums[i];

            int rem = prefixSum % k;
            if(rem < 0) rem += k;// to make an +ve
            if(map.containsKey(rem)){
                if(i - map.get(rem) >= 2){
                    return true;
                }
            }else{
                map.put(rem,i);
            }
        }
        return false;
    }
}