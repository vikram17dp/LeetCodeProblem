class Solution {// tc and sc is O(V+E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // step1: create an new adjacney list

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] preq:prerequisites){
            int course = preq[0];
            int prereq = preq[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        
        // step2: add all the prereq courses to indegree
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        // step3: BFS khans algo
        int completed = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            completed++;

            for(int neighbor:adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        // step4: check if all courses completed
        return completed == numCourses; // true or false
    }
}