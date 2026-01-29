class Solution { // tc is O(nsquare) and sc is O(1) // expand center
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0;i<n;i++){
            count += expand(s,i,i); // odd
            count += expand(s,i,i+1); // even
        }
        return count;

        
    }
    private int expand(String s,int start,int end){
        int count = 0;
   
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        } 

        return count;
    }
}