class Solution {
    private int findMaxEle(int[][] mat,int n ,int col){
        int maxvalue = -1;
        int index = -1;
        for(int i =0;i<n;i++){
            if(mat[i][col]>maxvalue){
                maxvalue = mat[i][col];
                index = i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            int maxRowIndex = findMaxEle(mat,n,mid);
            
            // left
            int left = (mid-1>=0) ? mat[maxRowIndex][mid-1] : -1;
            
            // right 
            int right = (mid+1<m) ? mat[maxRowIndex][mid+1] : -1;
            
            if(mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right){
                return new int[]{maxRowIndex,mid};
            }
            else if(left > mat[maxRowIndex][mid] ){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    
}