class Solution {// TC is O(N) and sc is O(M)
    public int numJewelsInStones(String jewels, String stones) {
        // case snestive if not convert into lower case for all strings
        HashSet<Character> jewelset = new HashSet<>();
        
        // add the diffent jewels into the sets
        
        for(int i = 0;i<jewels.length();i++){
            
            jewelset.add(jewels.charAt(i));
        }
        int count = 0;
        for(int i =0;i<stones.length();i++){
            // checking the jewel in stone sets
            if(jewelset.contains(stones.charAt(i))){
                count++;
            }
        }
        
        return count;
    }
}