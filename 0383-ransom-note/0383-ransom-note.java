class Solution { // tc is O(ransomNote + magazineMap) and sc is O(magazineMap)
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> magazineMap = new HashMap<>();
        
        for(char c:magazine.toCharArray()){
            magazineMap.put(c,magazineMap.getOrDefault(c,0)+1);
        }
        
        for(char c:ransomNote.toCharArray()){
            if(!magazineMap.containsKey(c) || magazineMap.get(c) == 0){
                return false;
            }
             // Decrease the count of the character in the magazine map
            magazineMap.put(c,magazineMap.get(c)-1);
        }
       
        return true;
    }
}