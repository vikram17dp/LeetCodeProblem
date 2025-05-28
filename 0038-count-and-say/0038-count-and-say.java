class Solution { // tc and sc is O(2ⁿ)
    public String countAndSay(int n) {
        if(n == 1) return "1";

        String prev = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        for(int i = 1;i< prev.length();i++){
            if(prev.charAt(i) == prev.charAt(i-1)){
                count++;
            }else{
                result.append(count).append(prev.charAt(i-1));
                count = 1;
            }
        }
        // apepend the last group
        result.append(count).append(prev.charAt(prev.length()-1));

        return result.toString();
    }
}