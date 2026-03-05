class Solution { // tc is O(n) and sc is O(n) whenever expression with addition is coming on that time we have to use the stack DS,+ and - are having same equality in BODMAS rule.
// in this one we have only +,-,(,). we dont have an * and / symbols.
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int num = 0;
        int sign = 1;

        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(c == ')'){
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        result += sign * num;
        return result;
    }
}