class Solution { // tc is O(n) and sc is O(n) for string concatation
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        String combined = s + s;
        return combined.contains(goal);
    }
}