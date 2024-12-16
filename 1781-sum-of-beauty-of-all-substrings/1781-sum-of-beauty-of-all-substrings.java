class Solution { // tc is O(nsquare * 26) and sc is O(1)
    
    private int getMinCount(int[] freq){
        int mincount = Integer.MAX_VALUE;
        for(int i =0;i<26;i++){
            if(freq[i]!=0){
                mincount = Math.min(mincount,freq[i]);
            }
        }
        return mincount;
    }
     private int getMaxCount(int[] freq){
        int maxcount = 0;
        for(int i =0;i<26;i++){
            maxcount = Math.max(maxcount,freq[i]);
        }
        return maxcount;
    }
    public int beautySum(String s) {
        
        int n = s.length();
        int sum =0;
        for(int i =0;i<n;i++){
            int[] freq = new int[26];
            for(int j = i;j<n;j++){
                freq[s.charAt(j) - 'a']++;
                int beauty = getMaxCount(freq) - getMinCount(freq);
                sum +=beauty;
            }
        }
        return sum;
    }
}