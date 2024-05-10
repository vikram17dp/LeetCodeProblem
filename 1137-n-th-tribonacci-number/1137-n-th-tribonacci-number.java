class Solution {
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1 || n == 2 ){
            return 1;
        }
        else{
            int FT = 0;
            int ST = 1;
            int TT = 1;
            for(int i=1;i<=n;i++){
                int FourthTerm = FT + ST + TT;
                FT= ST;
                ST = TT;
                TT = FourthTerm;  
        }
             return FT;
        }  
    }
}