class Solution { // tc and sc is o(n)
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for(char c: s.toCharArray()){
            if( c == '('){
                if(count>0){
                    result.append(c);
                }
                count++;
            }else{ // ')'
                count--;
                if(count > 0){
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}