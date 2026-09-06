class Solution { // tc is O(n) and sc is O(1)
    public int countRotations(String s, int k) {
        int n = s.length();
        int equal = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt((i + 1) % n)) {
                equal++;
            }
        }
        if (k == equal) {
            return n - equal;
        }
        if (k == equal - 1) {
            return equal;
        }
        return 0;
    }
}