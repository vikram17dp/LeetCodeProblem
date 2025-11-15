import java.util.*;

class Solution { // tc is O((N + E) log N) and sc is O(V + E)
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            adj.get(u).add(new int[]{v, w});  // u → v (w)
        }

        // Step 2: Distances array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // starting node

        // Step 3: Min-Heap (cost, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int node = cur[1];

            // If this popped entry is stale, skip it
            if (time > dist[node]) continue;

            for (int[] next : adj.get(node)) {
                int nei = next[0];
                int w = next[1];

                if (dist[node] + w < dist[nei]) {
                    dist[nei] = dist[node] + w;
                    pq.offer(new int[]{dist[nei], nei});
                }
            }
        }

        // Step 5: Find max distance (answer)
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max; // time for signal to reach all nodes
    }
}
