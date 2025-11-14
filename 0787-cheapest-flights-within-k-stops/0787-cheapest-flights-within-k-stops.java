class Solution { // tc is O(k * E) and sc is o(V+E)

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // step1: build adj list

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f: flights){
            int u = f[0];
            int v = f[1];
            int w = f[2];

            adj.get(u).add(new int[]{v,w});
        }
        // step2: distance array

        int[] dist = new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] =0;

        // Step 3: Normal BFS queue: (node, cost, stops)

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{src,0,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            // If stops exceed limit, skip
            if (stops > k) continue;

            // explore the neighbours

            for(int[] next : adj.get(node)){
                 int nextCity = next[0];
                int price = next[1];

                // Relaxation condition
                if (cost + price < dist[nextCity]) {
                    dist[nextCity] = cost + price;
                    q.offer(new int[]{nextCity, dist[nextCity], stops + 1});
                } 
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
} 