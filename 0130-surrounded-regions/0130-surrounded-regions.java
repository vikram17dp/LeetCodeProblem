class Solution { // tc and sc is O(n * m)
    public void solve(char[][] board) {
        int n = board.length;
        if(n == 0) return;
        int m = board[0].length;

        // step1: travsere throguh an bounderis

        for(int i = 0;i<n;i++){
            // first col and last col
            if(board[i][0] == 'O') dfs(board,i,0);
            if(board[i][m-1] == 'O') dfs(board,i,m-1);
        }
        for(int j = 0;j<m;j++){
            // first row and last row

            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[n - 1][j] == 'O') dfs(board, n - 1, j);
        }
        // step2:Flip all remaining 'O' -> 'X', and '#' -> 'O'

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }
    // DFS to mark safe 'O's as '#'
    private void dfs(char[][] board, int r, int c) {
        int n = board.length;
        int m = board[0].length;

        if (r < 0 || r >= n || c < 0 || c >= m || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#'; // mark safe

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}