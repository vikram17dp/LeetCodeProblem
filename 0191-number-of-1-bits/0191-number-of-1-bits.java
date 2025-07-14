class Solution { // tc is O(number of set bit) and sc is O(1)
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}