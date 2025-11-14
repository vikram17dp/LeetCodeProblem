import java.util.*;

class Solution { // tc is O(n * m * log(n * m)) and sc is O(n * m)


    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // effort[i][j] = minimum effort needed to reach (i, j)
        int[][] effort = new int[n][m];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        // Min-heap: {effort_so_far, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});  // effort, r, c

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];

            // If reached destination → best effort found
            if (r == n - 1 && c == m - 1) {
                return currEffort;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    // cost to move to next cell
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    int nextEffort = Math.max(currEffort, diff);

                    if (nextEffort < effort[nr][nc]) {
                        effort[nr][nc] = nextEffort;
                        pq.offer(new int[]{nextEffort, nr, nc});
                    }
                }
            }
        }

        return -1; // never happens
    }
}
