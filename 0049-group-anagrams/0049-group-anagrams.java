class Solution { // Tc and Sc is O(N*K) and K is the maximum length of the string
    
    private String getfrequencyString(String str){
        // creating an empty buckets
        int[] freq = new int[26];
        
        // iterate over each charcter
        for(char c:str.toCharArray()){
            freq[c-'a']++;
        }
        // start crating the frequency string
        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        
        for(int i :freq){
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
    
    public List<List<String>> groupAnagrams(String[] str) {
        // check for the empty inputs
        if(str == null || str.length == 0) return new ArrayList<>();
        
        HashMap<String,List<String>> frequencyStringMap = new HashMap<>();
        for(String strs :str){
            String frequencyString = getfrequencyString(strs);
            
            // if the frequcny string is prsent,add the string to the list
            if(frequencyStringMap.containsKey(frequencyString)){
                frequencyStringMap.get(frequencyString).add(strs);
            }
            else{
                // else create a new list
                
                List<String> strList = new ArrayList<>();
                
                strList.add(strs);
                frequencyStringMap.put(frequencyString,strList);
            }
        }
        return new ArrayList<>(frequencyStringMap.values());
    }
}