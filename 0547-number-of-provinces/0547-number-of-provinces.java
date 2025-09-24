class Solution {// tc is O(N^2) and sc is O(N)
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] isVisited = new boolean[V];
        int provinces = 0;
        for(int i = 0;i<V;i++){
            if(!isVisited[i]){
                provinces++;
                dfs(isConnected,i,isVisited);
            }
        }
        return provinces;
    }
    private void dfs(int[][] isConnected,int i,boolean[] isVisited){
        isVisited[i] = true;

        for(int j = 0;j<isConnected.length;j++){
            if(isConnected[i][j] == 1 && !isVisited[j]){
                dfs(isConnected,j,isVisited);
            }
        }
    }
}