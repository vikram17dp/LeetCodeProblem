class Solution { // tc is O(n) and sc is O(1)
    public int maxDepth(String s) {
        int ans =0,count = 0;
        char[] str = s.toCharArray();

        for(int i = 0;i<s.length();i++){
            if(str[i] == '('){
                count++;
                ans = Math.max(ans,count);
            }else if(str[i] == ')'){
                count--;
            }
        }
        return ans;
    }
}