class Solution { // O(1 ) and for the worst case is O(n)
    public int longestConsecutive(int[] nums) {
       int longest = 0;
        int n = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num:nums){
            set.add(num);
        }
       for(int num:set){
         if(!set.contains(num-1)){
             int currentnum = num;
             int count = 1;
             while(set.contains(currentnum+1)){
                 currentnum++;
                 count++;
             }
              longest = Math.max(longest, count);
         }
          
       }
         return longest;  
          
   
    
    }
}