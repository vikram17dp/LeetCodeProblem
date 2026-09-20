class Solution { // tc and sc is O(1)
    public int reverseDegree(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int reverseValue = 26 - (s.charAt(i) - 'a');
            int position = i + 1;

            ans += reverseValue * position;
        }

        return ans;
    }
}