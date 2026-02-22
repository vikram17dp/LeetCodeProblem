class Solution { // tc is O(n*m) and sc is O(26)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if(m>n) return result;
// step1: frequency the count of p
        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for(char ch: p.toCharArray()){
            pCount[ch - 'a']++;
        }
        // step2: first window
        for(int i = 0;i<m;i++){
            windowCount[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pCount,windowCount)){
            result.add(0);
        }
        // step3: slide the window
        for(int i = m;i<n;i++){
            windowCount[s.charAt(i) - 'a']++; // add char to window
            windowCount[s.charAt(i-m) - 'a']--; // remove char from window

            if(Arrays.equals(pCount,windowCount)){
                result.add(i - m + 1);
            }
        }
        return result;
    }
}