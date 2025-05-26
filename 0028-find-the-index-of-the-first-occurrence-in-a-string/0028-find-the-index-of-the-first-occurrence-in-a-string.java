class Solution { // tc is o(n) and sc is O(1)
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();

        for(int i = 0;i<=m-n;i++){
            if(haystack.substring(i,i+n).equals(needle)){
                return i;

            }
        }
        return -1;
    }
}