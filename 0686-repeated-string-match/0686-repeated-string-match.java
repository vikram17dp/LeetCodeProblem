class Solution {//O((n + m) * m) where n is length of a, m is length of b. and sc is O(n)
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }
 // Check if b is already a substring
        if(sb.toString().contains(b)) return count;

         // Check one more repetition (to cover overlap cases)
        sb.append(a);
        count++;

        if (sb.toString().contains(b)) return count;

        // If still not found, it's impossible
        return -1;
    }
}