class Solution { // tc is O(n/2)=>o(n) and sc is O(1)
    public double myPow(double x, int n) {
        
        long exp = n;
        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }
        double ans = 1.0;
        while(exp > 0){
            if(exp % 2 != 0){// odd 
                ans = ans * x;
            }
            x *= x;
            exp /= 2;
        }
        return ans;
        
    }
}