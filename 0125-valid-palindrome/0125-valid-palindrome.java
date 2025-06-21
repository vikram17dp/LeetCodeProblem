class Solution { // tc is O(n) and sc is O(1)
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        
       while(start<end){
          
           // skipping the all numeric values from the start
           while(start<end && !Character.isLetterOrDigit(s.charAt(start))){
               start++;
           }

            // skipping the all numeric values from the end
           while(start<end && !Character.isLetterOrDigit(s.charAt(end))){
               end--;
           }
           // edge case
           if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
               return false;
           }
           start++;
           end--;
       }
        return true;
    }
}