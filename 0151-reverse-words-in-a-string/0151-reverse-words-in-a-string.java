class Solution {
    public String reverseWords(String s) {
         String[] words = s.trim().split("\\s+");
        Stack<String> st = new Stack<>();
        
        
        for(String word:words){
            st.push(word);    
        }
        
        StringBuilder reverseStr = new StringBuilder();
        
        while(!st.isEmpty()){
            reverseStr.append(st.pop());
            if(!st.isEmpty()){
                reverseStr.append(" ");
            }
        }
        return reverseStr.toString();
    }
}