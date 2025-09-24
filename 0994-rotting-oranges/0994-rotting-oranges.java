class Solution { // tc and sc is O(n*m)
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;
// Step 1: Initialize the BFS queue with all initially rotten oranges
        // and count the total number of fresh oranges.
        for(int r = 0;r<m;r++){
            for(int c = 0;c<n;c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r,c});
                }else if(grid[r][c] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0){
            return 0;
        }
        // Define directions for 4-directional adjacency
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, down, up

        // step2:perform bfs
       while(!queue.isEmpty()){
            int levelSize = queue.size();
             boolean somethingRottenThisMinute  = false;
        for(int i =0;i<levelSize;i++){
            int[] currentOrange = queue.poll();
            int r = currentOrange[0];
            int c = currentOrange[1];

            for(int[] dir:directions){
                int nr = r + dir[0];// new row
                int nc = c + dir[1];// new col

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;// this fresh oranges becomes rottens
                    freshOranges--;
                    queue.offer(new int[]{nr,nc});
                    somethingRottenThisMinute  = true;
                }
            }
        }
         // If any fresh orange rotted in this minute, increment minutes
            // and there are still fresh oranges left.
            if (somethingRottenThisMinute && !queue.isEmpty()) { // queue.isEmpty() check is crucial to avoid incrementing minutes for the last batch of rotting
                 minutes++;
            }
       }
             // Step 3: After BFS, check if all fresh oranges have rotted
        if (freshOranges == 0) {
            return minutes;
        } else {
            return -1; // Some fresh oranges could not be rotted
        }
    }
}