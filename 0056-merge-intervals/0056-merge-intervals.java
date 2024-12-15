class Solution {
    public int[][] merge(int[][] intervals) {
        // base case
        if(intervals.length<=1){
            return intervals;
        } 
        // it will sort a/c to first vlaue of intervals
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        
        ArrayList<int[]> result = new ArrayList<>();
        
        int[] newIntervals = intervals[0];
        result.add(newIntervals);
        
        for(int[] interval : intervals){
            if(interval[0] <= newIntervals[1]){
                newIntervals[1] = Math.max(newIntervals[1],interval[1]);
            }else{
                newIntervals = interval;
                result.add(newIntervals);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}