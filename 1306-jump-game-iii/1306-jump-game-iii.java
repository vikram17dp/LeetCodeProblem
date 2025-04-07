class Solution { // tc is O(n) and sc is O(n)
    public boolean canReach(int[] arr, int start) {
        return dfs(arr,start);
    }
    private boolean dfs(int[] arr,int i){
        // base cases
        if(i < 0 || i >= arr.length || arr[i] < 0){
            return false;
        }
        // real cases
        if(arr[i] == 0){
            return true;
        }
        int jump = arr[i];
        arr[i] = -arr[i];

        return dfs(arr,i+jump) || dfs(arr,i-jump);
    }
}