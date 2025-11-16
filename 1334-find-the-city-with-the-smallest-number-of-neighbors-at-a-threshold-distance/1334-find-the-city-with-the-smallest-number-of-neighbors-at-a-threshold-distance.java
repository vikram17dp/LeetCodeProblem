class Solution { // tc is O(Ncube) and sc is O(Nsquare)
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int)1e9;

        int[][] dist = new int[n][n];

        // intailize the matrix

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // add the edges (bidirectional)

        for(int[] e: edges){
            int u = e[0],v = e[1],w= e[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        // floyds warshal algo

        for(int via = 0;via < n;via++){
            for(int i = 0;i<n;i++){
                if(dist[i][via] == INF) continue;
                for(int j = 0;j<n;j++){
                    if(dist[via][j] == INF) continue;

                    if(dist[i][via] + dist[via][j] < dist[i][j]){
                        dist[i][j] = dist[i][via] + dist[via][j];
                    }
                }
            }
        }
        int answerCity = 0;
        int minReachable = Integer.MAX_VALUE;
        // count reachable cities
        for(int i = 0;i<n;i++){
            int count = 0;
            for(int j = 0;j<n;j++){
                if(dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
                // choose city with fewest reachable
                // if tie → choose larger index
                if (count <= minReachable) {
                 minReachable = count;
                 answerCity = i;
            }
        }
        return answerCity;
    }
}