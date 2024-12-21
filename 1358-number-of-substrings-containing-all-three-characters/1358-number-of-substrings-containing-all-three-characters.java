class Solution { // tc is O(n2) and sc is O(1)
    public int numberOfSubstrings(String s) {
        int count = 0,left =0, n = s.length();
        int[] charCount = new int[3];
    
        for(int right = 0;right<n;right++){
            
         charCount[s.charAt(right)-'a']++;
            
            while(charCount[0] > 0 && charCount[1] > 0 && charCount[2] >0){
                count += n-right;
                charCount[s.charAt(left) - 'a']--;
                left++;
            }
            
               
           
        }
        return count;
    }
}