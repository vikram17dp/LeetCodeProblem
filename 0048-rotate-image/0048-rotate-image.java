class Solution {
    public void rotate(int[][] matrix) { // TC is O(n) and SC is O(n)
        
        int n = matrix.length;
        // step 1=> transpose the matrix
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // step 2 => reverse the matrix using swaping techinque
        for(int i = 0;i<n;i++){
        int left = 0,right =  n - 1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
    }
}


