class Solution { // tc is O(N X K) => k = 26 so tc is O(n) and sc is O(N X K)

    private String getFrequencyString(String str) {

        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder key = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            key.append((char) ('a' + i));
            key.append(freq[i]);
        }

        return key.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            String key = getFrequencyString(str);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}