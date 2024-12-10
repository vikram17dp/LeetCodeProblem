class Solution { // tc is O(n) and sc is O(1)
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        
        while(start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;  
            }else{
               return validpalindromefun(s,start+1,end) || validpalindromefun(s,start,end-1); 
            }
           
        }
        return true; 
    }
     private boolean validpalindromefun(String s,int start,int end){
            while(start<end){
            if(s.charAt(start) != s.charAt(end)){
               return false;
            }
            start++;
            end--;
}
        return true;
}
}