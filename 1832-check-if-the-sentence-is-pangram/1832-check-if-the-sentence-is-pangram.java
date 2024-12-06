class Solution { // Tc is O(n) and sc is O(1)
    public boolean checkIfPangram(String sentence) {
       HashSet<Character> alphabetSet = new HashSet<>();
        // add all letters to the set
        for(int i ='a';i<='z';i++){
            alphabetSet.add((char)i);  
        }
        // after adding the remove letters
        for(int i =0;i<sentence.length();i++){
            alphabetSet.remove(sentence.charAt(i));
            if(alphabetSet.isEmpty()) return true;
        }
        return false;
    }
}