class Solution { // tc and sc is O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> result = new ArrayList<>();
        
        int i = 0;
        int n = intervals.length;
        
        // Step 1: Add all intervals that come before newInterval
        while(i<n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        // Step 2: Merge overlapping intervals with newInterval
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);

         // Step 3: Add all intervals that come after newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
 // Convert result list to 2D array
        return result.toArray(new int[result.size()][]);
    }
}