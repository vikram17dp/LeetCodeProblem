class Solution { // tc is O(n) and sc is O(256)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxlength = 0;
        int left = 0;
        
        for(int right =0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right)); 
            maxlength = Math.max(maxlength,right-left+1);

             
        }
        return maxlength;
    }
}