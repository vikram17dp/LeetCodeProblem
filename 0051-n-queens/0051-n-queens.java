class Solution { // tc is O(N!) and sc is O(N^2)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // intailize the board with '.'
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(0,board,result,n);
        return result;
        
    }
    private void backtrack(int row,char[][] board,List<List<String>> result,int n){
        if(row == n){
            result.add(construct(board));
            return;
        }
        for(int col = 0;col<n;col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';
                backtrack(row+1,board,result,n);
                board[row][col] = '.';// backtrack
            }
        }
    }
    private boolean isSafe(char[][] board,int row,int col,int n){
        // check colum
        for(int i = 0;i<row;i++){
            if(board[i][col] == 'Q') return false;
        }
        // check for the left diagonal
        for(int i = row-1,j = col-1;i>=0 && j>= 0;i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        // check for the right diagonal
        for(int i = row-1,j = col+1;i>= 0 && j <n;i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row:board){
            list.add(new String(row));

        }
        return list;
    }
}