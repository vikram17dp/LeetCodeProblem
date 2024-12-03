class Solution {
    public String sortSentence(String s) {
        String[] words =s.split(" ");
        
        String[] sortedWords = new String[words.length];
        
         for (String word : words) {
            // Extract the position number (last character of the word)
            int position = word.charAt(word.length() - 1) - '0';
            
            // Remove the number and place the word at the correct position
            sortedWords[position - 1] = word.substring(0, word.length() - 1);
        }
        // Join the words back into a sentence
        return String.join(" ", sortedWords);
    }
}