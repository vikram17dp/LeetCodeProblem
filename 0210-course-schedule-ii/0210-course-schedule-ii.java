class Solution {// tc and sc is O(V+E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // step1: create an new adjacney list

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] preq:prerequisites){
            int course = preq[0];
            int prereqs = preq[1];
            adj.get(prereqs).add(course);
            indegree[course]++;
        }

        // Step 2: Add all courses with no prerequisites (indegree = 0)

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        // step3:apply the bfs khans algo

        List<Integer> topo = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);

            for(int negihbor:adj.get(node)){
                indegree[negihbor]--;
                if(indegree[negihbor] == 0){
                    queue.offer(negihbor);
                }
            }
            
        }
        // step4: check wheter could we complete all tasks
        if(topo.size() != numCourses){
            return new int[0]; // cycle detected → impossible
        }
          // Step 5: Convert List<Integer> → int[]
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = topo.get(i);
        }

        return order; 
    }
}