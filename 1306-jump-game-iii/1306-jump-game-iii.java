class Solution { // tc is O(n) and sc is O(n)
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int curr = queue.poll();

             // If we reached a 0
            if (arr[curr] == 0) return true;

            int forward = curr + arr[curr];
            int backward = curr - arr[curr];

            if(forward < arr.length && !visited[forward]){
                queue.offer(forward);
                visited[forward] = true;
            }
            if(backward >= 0 && !visited[backward]){
                queue.offer(backward);
                visited[backward] = true;
            }
        }
        return false;
    }
    
}