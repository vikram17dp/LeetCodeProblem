class Solution { 
    public void setZeroes(int[][] matrix) { // tc is O(n*m) * O(n*m) and sc is o(n) + O(m)
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        // then travse to the col and row array
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(row[i]== 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    
    
    }
}