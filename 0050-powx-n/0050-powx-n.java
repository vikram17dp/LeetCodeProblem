class Solution { // tc is O(logn) and sc is O(1) // iterative approach
    public double myPow(double x, int n) {
        
        long exp = n;
        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }
        return power(x,exp,1);
    }
    double power(double x,long n,double ans){
        if(n == 0) return ans;
        if(n % 2 != 0){
            ans *= x;
        }
        return power(x*x,n/2,ans);
    }
}