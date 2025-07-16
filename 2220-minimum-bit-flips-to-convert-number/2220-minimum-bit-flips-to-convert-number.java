class Solution { // tc is O(31) or logbase2(start^goal) and sc is o(1)
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int count = 0;
        for(int i = 0;i<31;i++){
            if ((ans & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}