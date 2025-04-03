class Solution {// tc is o(n) and sc is O(1)
    public boolean checkValidString(String s) {
        int low = 0,high=0;
        for(char c:s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }else if(c == ')'){
                low--;
                high--;
            }else{
                low--;// '*' treated as ')'
                high++; // '*' treated as '('
            }
            if(low<0) low =0;
            if(high <0) return false;
        }
        return low ==0;
    }
}