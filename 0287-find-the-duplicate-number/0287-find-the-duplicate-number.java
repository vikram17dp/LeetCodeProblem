class Solution { // tc is O(n) and sc is O(1)
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeatNum = 0;
        for(int num:nums){
            if(set.contains(num)){
                repeatNum = num;
                return num;
            }
            set.add(num);
        }
        return repeatNum;
    }
}