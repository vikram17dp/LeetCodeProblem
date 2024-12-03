class Solution {
    public int lengthOfLastWord(String s) { // Tc is O(n) and Sc is O(1)
        String[] words = s.split(" ");
        
        String lastword = words[words.length-1];
        
        return lastword.length();
    }
}