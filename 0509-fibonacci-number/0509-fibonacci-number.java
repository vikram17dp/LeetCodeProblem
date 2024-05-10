class Solution {
    public int fib(int n) {
       if(n == 0){
           return 0;
       } else if(n == 1){
           return 1;
       }
        // FT = FirstTerm like that for all same only
        int FT=0;
        int ST=1;
        for(int i=1;i<=n;i++){
            int TT = FT + ST;
            FT = ST;
            ST = TT;
        }
        return FT;
        
        
    }
}