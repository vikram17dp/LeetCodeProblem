class Solution {
    public boolean isAnagram(String str1, String str2) { // TC is O(N) and Sc is O(1)
        // converting all the strings into the lowercase
        str1 = str1.toLowerCase();

        str2 = str2.toLowerCase();
        
        // removing the whitespaces
        str1 = str1.replace(" ","");
        str2 = str2.replace(" ","");
        
        // intailze the bucket array of 26 
        
        int[] counts = new int[26];
        
        //fill the bucktes
        for(int i = 0;i<str1.length();i++){
            counts[str1.charAt(i)-'a']++;
        }
        
        // empty the buckets
        for(int i = 0;i<str2.length();i++){
            counts[str2.charAt(i)-'a']--;
        }
        // apply the for each loop to travse entrie array
        
        for(int count:counts){
            if(count!=0){
                return false;
            }
            
        }
        return true;
    }
}