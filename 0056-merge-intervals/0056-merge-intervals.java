class Solution {// tc is O(nlogn) and sc is O(n) Sorting + Two Pointers
    public int[][] merge(int[][] intervals) {
        // base case
        if(intervals.length <= 1) return intervals;


        // sort the intervals based on the 0th indexed only
        //[1,3] arrays means [0,1] style it is saved

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] <= current[1]){
                current[1] = Math.max(current[1],intervals[i][1]);
            }else{
                // add to the result;
                result.add(current);
                current = intervals[i];
            }
        }
            // add the last intervals
            result.add(current);

        return result.toArray(new int[result.size()][]);
        
    }
}