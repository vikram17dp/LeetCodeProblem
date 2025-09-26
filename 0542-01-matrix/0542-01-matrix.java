class Solution { // tc and sc is O(N * M)
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            dist[r][c] =d;
            for(int[] dir:directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc,d+1});
                }
            }
        }
        return dist;

    }
}