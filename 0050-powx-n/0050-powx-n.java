class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long newNum = n;
        if(newNum < 0) newNum = -1*newNum; // here we are converting -ve To +ve
        while(newNum > 0){
            if(newNum % 2 == 1){ // for odd number
                ans = ans*x;
                newNum = newNum - 1;
            }else{ // for even number
                x = x*x;
                newNum = newNum / 2;
            }
        }
        if(n < 0 ) ans = (double)(1.0) / (double)(ans);
        return ans;
    }
}