class Solution {
    public String restoreString(String s, int[] indices) { // tc and sc is o(n)
        // // we have to store in the array of char
        char[] str = new char[s.length()];
        // // loop through the array of char
        for(int i = 0;i<s.length();i++){
            str[indices[i]] = s.charAt(i);
        }
        // // return the string of that array
        return String.valueOf(str);
        
       
    }
}