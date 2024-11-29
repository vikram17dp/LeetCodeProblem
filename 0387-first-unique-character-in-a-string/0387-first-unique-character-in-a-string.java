class Solution {
    public int firstUniqChar(String str) { // Tc is O(N)
        int index = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        
        // update the map with current letters
        for(int i =0;i<str.length();i++){
            char c = str.charAt(i);
            int freq = map.getOrDefault(c,0);// it will count the unique strings
            map.put(c,(freq+1));
        }
        // getting the unique string from the hashmap
        for(int i =0;i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                index = i;
                break;
            }
        }
        return index;
    }
}