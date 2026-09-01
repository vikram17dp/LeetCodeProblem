class Solution { // tc is o(n) and sc is O(1)
    public int fib(int n) {
    //     if(n == 0){
    //        return 0;
    //    } else if(n == 1){
    //        return 1;
    //    }
    if(n <= 1) return n;
       // FT = FirstTerm like that for all same only
        int FT=0;
        int ST=1;
        for(int i=2;i<=n;i++){
            int TT = FT + ST;
            FT = ST;
            ST = TT;
        }
        return ST;
    }
}