class Solution { // tc is O(V + E) — every node and edge is processed once and sc is O(V)
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];// unvisted = 0,red = 1,blue = -1

        for(int i = 0;i<n;i++){
            if(color[i] == 0){
                if(!dfs(graph,color,i,1)){
                    return false;
                }
            }
        }
        return true;

    }
    private boolean dfs(int[][] graph,int[] color,int node,int currentColor){
        color[node] = currentColor;

        for(int neighbor:graph[node]){
             if (color[neighbor] == 0) {
                if (!dfs(graph, color, neighbor, -currentColor))
                    return false;
            } else if (color[neighbor] == color[node]) {
                return false; // conflict
            }
        }
        return true;
    }
}