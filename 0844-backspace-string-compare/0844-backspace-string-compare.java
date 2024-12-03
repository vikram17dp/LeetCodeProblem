class Solution { // we can solve this one in the so many ways like two pointers and stack and hashmap and normal string - 4 ways
    // public boolean backspaceCompare(String s, String t) { // TC is o(n) and SC is O(n)
    //     return processString(s).equals(processString(t));
    // }
    
    // using the stringbuilder techinque for this problem
//     private String processString(String str){
//         StringBuilder result = new StringBuilder();
        
//         for(char c:str.toCharArray()){
//             if(c == '#'){
//                if(result.length()>0){
//                    result.deleteCharAt(result.length()-1);
//                }} else{
//                    result.append(c);
//                }
            
//         }
     // return result.toString();// mehtod one
    
    public boolean backspaceCompare(String s, String t) {
        return usingStack(s).equals(usingStack(t));
    }
    
    
    // using the stack method
    
    private String usingStack(String str){ // Tc is O(n+m) and sc is O(n)
        Stack<Character> stack = new Stack<>();
        for(char c:str.toCharArray()){
            if(c == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString(); // we have to do the revrse for stack 
    }   
        
}
