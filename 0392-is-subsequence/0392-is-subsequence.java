class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        if(s.isEmpty()) return true;
        
        int sIndex = 0,tIndex = 0;
        while(sIndex<s.length() && tIndex <t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}