class Solution { // tc is O(n⋅log(max−min)) and sc is O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        // edge case
        if((long)m*k > bloomDay.length) return -1;
       int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        
        for(int day:bloomDay){
            min = Math.min(min,day);
            max = Math.max(max,day);
        }
        
        while(min<max){
            int mid = min + (max-min)/2;
            if(canMakeBouquets(bloomDay,mid,m,k)){
               max = mid;
            }else{
                min= mid+1;
            }
        }
        return min;
         
}
     private boolean canMakeBouquets(int[] bloomDay, int days, int m, int k){
         int count = 0,bockquet = 0;
         
         for(int day:bloomDay){
             if(day<=days){
                 count++;
                 if(count == k){
                     bockquet++;
                     count = 0;
                 }
             }else{
                 count = 0;
             }
             if(bockquet >= m) return true;
         }
         return false;
     }
}