class Solution { // tc is O((n + roads.length) log n) and sc is O(n + roads.length)

    public int countPaths(int n, int[][] roads) {
        // step1: create an adj list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] r: roads){
            int u = r[0],v =r[1],w=r[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        // step2: create and dist and ways array

        int MOD = 1_000_000_007;
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1; // at least one ways is required to reach the souce node

        // step3: min heap

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0,0}); // {distance,node}

        // step4: djikstras algo

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long currDist = curr[0];
            int node = (int) curr[1];

             if (currDist > dist[node]) continue;

            for (int[] next : adj.get(node)) {
                int nei = next[0];
                int wt = next[1];

                long newDist = currDist + wt;

                // Case 1: shorter path found → update distance + ways
                if (newDist < dist[nei]) {
                    dist[nei] = newDist;
                    ways[nei] = ways[node];
                    pq.offer(new long[]{newDist, nei});
                }

                // Case 2: same shortest path → add ways
                else if (newDist == dist[nei]) {
                    ways[nei] = (ways[nei] + ways[node]) % MOD;
                }
            }
        }
        return (int) (ways[n - 1] % MOD);
    }
}