class Solution { // fixed window,anagram type so freq method tc & sc is O(n)
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m>n) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // step1: frequency window for s1
        for(char ch: s1.toCharArray()){
            s1Count[ch - 'a']++;
        }
        // step2: frequency window for s2
        for(int i = 0;i<m;i++){
            windowCount[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1Count,windowCount)){
            return true;
        }
        // step3: shrink the window
        for(int i = m;i<n;i++){
            // add new char 
            windowCount[s2.charAt(i) - 'a']++;
            windowCount[s2.charAt(i-m)- 'a']--;

            if(Arrays.equals(s1Count,windowCount)){
                return true;
            }
        }
        return false;
    }
}