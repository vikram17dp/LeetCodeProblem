class Solution { // tc is O(n) and sc is O(k)
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        long sum = 0;
        long maxSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int right = 0;right<nums.length;right++){
            sum += nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);

            if(right - left + 1> k){
                int leftvalue = nums[left];
                sum -= leftvalue;

                map.put(leftvalue,map.get(leftvalue)-1);
                if(map.get(leftvalue) == 0){
                    map.remove(leftvalue);
                }
                left++;
            }
            if(right-left+1 == k){
                if(map.size() == k){
                    maxSum = Math.max(maxSum,sum);
                }
            }
        }
        return maxSum;
    }
}