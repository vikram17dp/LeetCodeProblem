class Solution { // tc is O(n) and sc is o(n)
    public int minLength(String s) {
        
        StringBuilder sb = new StringBuilder();

        for(char ch:s.toCharArray()){
            int len = sb.length();

            if(len > 0 &&
               ((sb.charAt(len-1) == 'A' && ch == 'B') ||
                (sb.charAt(len-1) == 'C' && ch == 'D'))){

                sb.deleteCharAt(len-1);
            }else{
                sb.append(ch);
            }
        }
        return sb.length();
    }
}