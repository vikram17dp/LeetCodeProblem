class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] alphabet = new boolean[26];
        int count = 0;
        sentence =sentence.toLowerCase();
        for(char c:sentence.toCharArray()){
            if(c>='a' && c<='z'){
                int index = c-'a';
                if(!alphabet[index]){
                    alphabet[index] = true;
                    count++;
                    if(count == 26) return true;
                }
            }
        }
        return false;
    }
}