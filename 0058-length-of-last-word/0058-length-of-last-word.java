class Solution {
//     public int lengthOfLastWord(String s) { // Tc is O(n) and Sc is O(n)
//         String[] words = s.split(" ");
        
//         String lastword = words[words.length-1];
        
//         return lastword.length();
//     }
    
    // we cant use the extra space to store the string
    
     public int lengthOfLastWord(String s) { // Tc is O(n) and sc is O(1)
        int count = 0;
         for(int i = s.length()-1;i>=0;i--){
             // we dont have the white space
             if(s.charAt(i) != ' '){
                 count++;
             }else{
                 // we found the white space 
                 // we are starting to find the word
                 // yes really we got the word
                 if(count>0) return count;
             }
         }
         return count;
         
     }
    
    
}