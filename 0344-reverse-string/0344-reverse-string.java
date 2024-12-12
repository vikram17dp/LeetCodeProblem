class Solution { // tc & sc is O(1)
    public void reverseString(char[] s) {
        int low = 0,high = s.length-1;
        while(low<high){
            char temp = s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }
}