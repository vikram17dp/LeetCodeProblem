import java.util.HashMap;

public class Solution { // tc is O(m+n) and sc is O(n)
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0, min_length = Integer.MAX_VALUE;
        int startIndex = 0, required = tFreq.size(), formed = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < min_length) {
                    min_length = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar) < tFreq.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return min_length == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + min_length);
    }

    
}
