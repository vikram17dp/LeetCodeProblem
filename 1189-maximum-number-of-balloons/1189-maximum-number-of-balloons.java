class Solution { // tc O(n) & sc O(1)
    public int maxNumberOfBalloons(String text) {
        // storing the input text
        HashMap<Character,Integer> freqMap = new HashMap<>();
        
        for(char c:text.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        // storing the word
        
        HashMap<Character,Integer> balloonMap = new HashMap<>();
        balloonMap.put('b',1);
        balloonMap.put('a',1);
        balloonMap.put('l',2);
        balloonMap.put('o',2);
        balloonMap.put('n',1);
        
        int mincount = Integer.MAX_VALUE;
        for(char c:balloonMap.keySet()){
            if(!freqMap.containsKey(c)){
                return 0;
            }
            int count = freqMap.get(c) / balloonMap.get(c);
             mincount = Math.min(mincount,count); 
        }
        return mincount;
        
    }
}