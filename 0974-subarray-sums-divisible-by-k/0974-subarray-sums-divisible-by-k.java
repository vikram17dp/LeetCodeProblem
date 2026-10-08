class Solution { // tc is O(n) and sc is O(n) prefixsum pattern + modulo + freq approach
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;

        for(int num:nums){
            prefixSum += num;

            int rem = prefixSum % k;

            if(rem<0) rem += k;// handle -ve rem

            count += map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0) + 1);
        }
        return count;
    }
}