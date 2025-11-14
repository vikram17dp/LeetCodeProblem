class Solution { // tc and sc is O(nsquare)
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // if start and end are blocked
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }   
        // BFS Queue :{row,col,distance}

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});// distance will start at 1

        grid[0][0] = 1; 

        int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int r = curr[0],c = curr[1],dist = curr[2];

            // destination is reached

            if(r == n-1 && c == n-1) return dist;

            for(int[] d :dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>= 0 && nc>= 0 && nr<n && nc<n && grid[nr][nc] ==0){
                    grid[nr][nc] = 1;// mark visited
                    q.offer(new int[]{nr,nc,dist+1});
                }
            }
        }
        return -1;
    }
}