class Solution {
    public int myAtoi(String s) {
        //remove the whitespace
        s = s.trim();
        
        if(s.length() == 0) return 0;
        
        int sign = +1;
        
        long ans = 0;
        int min = Integer.MIN_VALUE,max = Integer.MAX_VALUE;
        
        // itailize the pointer 
        
        int i = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1: 0;
        
        if(s.charAt(0) == '-') sign = -1;
        
        while(i<s.length()){
            // main case
            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) break;
            
            ans = ans*10 + s.charAt(i) - '0';
            
            if(sign == -1 && -1*ans<min) return min ;
            if(sign == +1 && ans>max) return max;
            i++;
            
        }
        return (int)(sign*ans); 
    }
}