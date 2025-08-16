class Solution {
    public List<Integer> spiralOrder(int[][] matrix) { // O(m * n) and sc is o(n*m)
        List<Integer> result  = new ArrayList<>();
        
        int left = 0,right = matrix[0].length-1,top = 0,bottom = matrix.length-1;

        if(matrix == null || matrix.length == 0){
            return result;
        }

        // left to right
        while(top<=bottom && left<= right){
            for(int i = left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
        // top to bottom
            for(int i = top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;

            // right of bottom to left of bottom

            if(top<=bottom){
                for(int i = right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // bottom to top
            if(left<=right){
                for(int i = bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
            return result;

    }
}