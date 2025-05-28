class Solution { // tc is O(N) and sc is O(1)
    public int minAddToMakeValid(String s) {
        int open = 0,close = 0;
        for(char c :s.toCharArray()){
            if(c == '('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    close++;
                }
            }
        }
        return open+close;
    }
}