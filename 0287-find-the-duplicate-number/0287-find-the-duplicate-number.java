class Solution { // tc is o(nlogn)
    public int findDuplicate(int[] nums) {
          HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(num)) {
                return num; // Return the duplicate number
            }
            seen.add(num);
        }
        
        return -1; 
    }
}