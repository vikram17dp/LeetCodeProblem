class Solution {
    public String restoreString(String s, int[] indices) { // tc and sc is o(n)
        // // we have to store in the array of char
        // char[] str = new char[s.length()];
        // // loop through the array of char
        // for(int i = 0;i<s.length();i++){
        //     str[indices[i]] = s.charAt(i);
        // }
        // // return the string of that array
        // return String.valueOf(str);
        
        HashMap<Integer,Character> map = new HashMap<>(); // tc and sc is o(n)
        
        for(int i =0;i<s.length();i++){
            map.put(indices[i],s.charAt(i));
        }
        
        StringBuilder result = new StringBuilder(s.length());
        
        for(int i =0;i<s.length();i++){
            result.append(map.get(i));
        }
        return result.toString();
    }
}