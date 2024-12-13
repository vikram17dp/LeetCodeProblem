class Solution { // tc isO(max(n,m)) and sc is O(n+m)
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i =0,j=0;
        
        while(i<word1.length() || j<word2.length()){
            if(i<word1.length()){
                result.append(word1.charAt(i));
                i++;
            }
             if(j<word2.length()){
                result.append(word2.charAt(j));
                j++;
            }
        }
        return result.toString();
    }
}