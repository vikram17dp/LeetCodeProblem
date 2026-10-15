import java.util.*;

class Solution { // tc is (O(n + mlog m)) and sc is O(n+m)
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count character frequencies
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Sort characters by frequency
        List<Character> list =
            new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) ->
            map.get(b) - map.get(a)
        );

        // Build the result
        StringBuilder result = new StringBuilder();

        for (char c : list) {
            int freq = map.get(c);

            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}