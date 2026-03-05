class Solution { // tc is O(n) and sc is O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token:tokens){
            if(token.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            }else if(token.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }else if(token.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            }else if(token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}