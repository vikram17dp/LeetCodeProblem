class Solution { // tc is o(n) and sc is O(1)
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length,n = matrix[0].length;
        int[] arr = new int[m * n];
        int index = 0;
        int row = 0,col = 0;
        boolean up = true;

        while(row< m && col < n){
            // if diagonal going up
            if(up){
                while(row > 0 && col < n-1){
                    arr[index++] = matrix[row][col];
                    row--;
                    col++;
                }
                arr[index++] = matrix[row][col];
                if(col == n-1) row++;
                else col++;
            }else{
            // or diagonal going down
                while(col > 0 && row < m-1){
                    arr[index++] = matrix[row][col];
                    row++;
                    col--;
                }
                arr[index++] = matrix[row][col];
                if(row == m-1) col++;
                else row++;
            }
        // or down
        up = !up;
        }
        return arr;
    }
}