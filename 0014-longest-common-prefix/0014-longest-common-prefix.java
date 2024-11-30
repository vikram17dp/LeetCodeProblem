class Solution {// TC is O(NlogN) and sc is O(1) and using the qucik sort we can do the fast sorting
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        
        Arrays.sort(strs);
        // getting the first and last element
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        // start comparing the first and last char
         for(int i =0;i<first.length;i++){
            if(first[i]!=last[i]){
                break;
            }
             result.append(first[i]);
             
        }
        return result.toString();
    }
}