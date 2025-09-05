class Solution { // tc is O(4^n * sqrt(n)) and sc is O(n) for string builder approach
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuilder(),n,n);
        return result;
    }
    public static void backtrack(List<String> result,StringBuilder current,int open,int close){
        // base case
        if(open == 0 && close == 0){
            result.add(current.toString());
            return;
        }

        // if "(" comes means

        if(open > 0){
            current.append("(");
            backtrack(result,current,open-1,close);
            current.deleteCharAt(current.length() - 1);// this one is for backtrack after getting the string result we will go back to original state thats why we have to delete the stuff
        }
        // if ")" comes means
        if(close > 0 && close > open){
            current.append(")");
            backtrack(result,current,open,close-1);
            current.deleteCharAt(current.length()-1);
        }
    }
}