class Solution { // tc is O(sqrt(num)) and sc is O(1)
    public boolean isPerfectSquare(int num) {
        if(num < 1) return false;
       long  low = 1,high = num;
       while(low<=high){
           long mid = low + (high-low)/2;
           long sqrtnum = mid*mid;
           if(sqrtnum == num ){
               return true;
           }else if(sqrtnum<num){
              low = mid+1;
           }else{
               high = mid-1;
           }
       }
        return false;
    }
}