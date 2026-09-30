class Solution { // tc is O(n) and sc is O(1) two way traversal using open and close variables
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int open = 0,close = 0;

        // left to right traversal
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                close++;
            }
            if(open == close){
                maxLen = Math.max(maxLen,2 * close);
            }else if(close > open){
                open = close = 0;
            }
        }

        open = close = 0;
        // right to left traversal
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == '('){
                open++;
            }else if(s.charAt(i) == ')'){
                close++;
            }
            if(open == close){
                maxLen = Math.max(maxLen,2 * open);
            }else if(open > close){
                open = close = 0;
            }
        }
        return maxLen;
    }
}