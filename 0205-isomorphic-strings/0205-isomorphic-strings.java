class Solution { // tc is O(n) and sc O(26 or 128) 26-english letters and other Asiic char
    public boolean isIsomorphic(String s, String t) {
      // base case
        if(s.length()!=t.length()) return false;
        
        HashMap<Character,Character> charMap = new HashMap<>();
        
        for(int i =0;i<s.length();i++){
            char original = s.charAt(i);
            char replacment = t.charAt(i);
            
            if(!charMap.containsKey(original)){
                if(!charMap.containsValue(replacment)){
                   charMap.put(original,replacment);
                }else{
                     return false;
                }
            }else{
                char mappedChar = charMap.get(original);
                if(mappedChar != replacment){
                    return false;
                }
            }
        }
        return true;
    }
}