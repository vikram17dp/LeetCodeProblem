class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1){
            return false;
        }
        else if(n == 1){
            return true;
        }else{
            while(n%2 == 0){ // if the n = 20 then it will divide that number and 20/2=10 10/2=5 then 5/2=remainder 1 then i will flase 
                n = n/2;
            }
            if(n == 1){
                return true;
            }else{
                return false; // it will come here and because 5 == 1 not true so it returnb false
            }
        }
        
    }
}