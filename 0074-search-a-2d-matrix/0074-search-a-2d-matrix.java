class Solution {
    public boolean searchMatrix(int[][] matrix, int target) { // TC is o(n*(logm))
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0 || m == 0){
            return false;
        }
       
        int low = 0;
        int high = n*m-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
        
    }
    
}