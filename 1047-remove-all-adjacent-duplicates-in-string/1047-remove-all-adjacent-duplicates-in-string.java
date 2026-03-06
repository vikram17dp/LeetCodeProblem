class Solution { // tc is O(n) and sc is O(n)
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray()){
            if(!stack.isEmpty() &&  stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();

        for(char ch:stack){
            result.append(ch);
        }
        return result.toString();
    }
}