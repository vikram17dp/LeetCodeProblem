class Solution { // tc is O(n^2 · α(n))   almost O(n²) and sc is O(n)
    static class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i =0;i<n;i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x,int y){
            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(rank[px] < rank[py]){
                parent[px] = py;
            }else if(rank[py] > rank[px]){
                parent[py] = px;
            }else{
                parent[py] = px;
                rank[px]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;

        DSU dsu = new DSU(n);
 // union stones that share row or column

        for(int i = 0;i<n;i++){
            int x1 = stones[i][0];
            int y1 = stones[i][1];

            for(int j = i+1;j<n;j++){
                int x2 = stones[j][0];
                int y2 = stones[j][1];
// if same row or same column → union
                if(x1 == x2 || y1 == y2){
                    dsu.union(i,j);
                }
            }
        }
        // count connected components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                components++;
            }
        }

        // answer = total stones - number of connected components
        return n - components;

    }
}