class Solution { // tc is (n⋅log(sum of weights)) and sc is O(1)
    
    private int findDays(int[] weights,int cap){
        int load = 0,days = 1;
        
        for(int i =0;i<weights.length;i++){
            if(load + weights[i] > cap){
                days += 1;
                load = weights[i];  
            }else{
                load += weights[i];
            }
        }
        return days;
        
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        for(int i =0;i<weights.length;i++){
            low = Math.max(low,weights[i]);
        }
        
        int sum = 0;
        for(int i =0;i<weights.length;i++){
            sum += weights[i];
           
        }
        int high = sum;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            int noOfDays = findDays(weights,mid);
            
            if(noOfDays<= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}