class Solution { // tc is O(logn) and sc is O(1)
    public int mySqrt(int x) {
        // base case
        if(x == 0 || x== 1) return x;
        int low = 1,high = x,ans = 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            if((long)mid*mid == x){
                return mid;
            }else if((long)mid*mid < x){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }  
        return ans;
    }
}