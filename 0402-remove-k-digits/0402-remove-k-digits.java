class Solution { // tc is O(n) + O(k) and sc is O(n) 
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<num.length();i++){
            char currentChar = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() > currentChar){
                stack.pop();
                k--;
            }
            stack.push(currentChar);
        }
        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        result.reverse();

        while(result.length() > 0 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
       
        return result.length() == 0 ? "0" : result.toString();
    }
}