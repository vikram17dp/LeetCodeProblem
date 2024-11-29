class Solution { // Tc is O(nsquare) and Sc is O(1)
    public String longestPalindrome(String str) {
        // Base Case
        if(str.length()<=1) return str;
        
        String LPS = "";
        
        for(int i =1;i<str.length();i++){
            // odd length
            int low = i;
            int high = i;
            while(str.charAt(low) == str.charAt(high)){
                low--;
                high++;     
                
                if(low == -1 || high == str.length()) break;
            }
                
                String palindrome = str.substring(low+1,high);
                
                if(palindrome.length() > LPS.length()){
                    LPS = palindrome;
                }
              // even length
                
                low = i-1;
                high = i;
                
                while(str.charAt(low) == str.charAt(high)){
                    low--;
                    high++;
                    if(low == -1 || high == str.length()) break;
                }
                    palindrome = str.substring(low+1,high);
                    if(palindrome.length() > LPS.length()){
                    LPS = palindrome;
                }
                }
                return LPS;
            
    }
    
}