class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){

                isVisited[i][j] = true;
                if( solve(0,i,j,board,word,isVisited)){
                    return true;
                }
                isVisited[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean solve(int curr,int row,int col,char[][] board,String word,boolean[][] isVisited){
        // base case
        if(curr == word.length()-1) return true;

        // up
        if(row-1>=0 && board[row-1][col] == word.charAt(curr+1) && !isVisited[row-1][col]){
            isVisited[row-1][col] = true;
            boolean ans = solve(curr+1,row-1,col,board,word,isVisited);
            if(ans) return true;
            isVisited[row-1][col] = false;
        }
        // down
        if(row+1<board.length && board[row+1][col] == word.charAt(curr+1) && !isVisited[row+1][col]){
            isVisited[row+1][col] = true;
            boolean ans = solve(curr+1,row+1,col,board,word,isVisited);
            if(ans) return true;
            isVisited[row+1][col] = false;
        }
        // left
        if(col -1 >= 0 && board[row][col-1] == word.charAt(curr+1) && !isVisited[row][col-1]){
            isVisited[row][col-1] = true;
            boolean ans = solve(curr+1,row,col-1,board,word,isVisited);
            if(ans) return true;
            isVisited[row][col-1] = false;
        }
        // right
        if(col +1 < board[0].length && board[row][col+1] == word.charAt(curr+1) && !isVisited[row][col+1]){
            isVisited[row][col+1] = true;
            boolean ans = solve(curr+1,row,col+1,board,word,isVisited);
            if(ans) return true;
            isVisited[row][col+1] = false;
        }
        return false;
    }
}