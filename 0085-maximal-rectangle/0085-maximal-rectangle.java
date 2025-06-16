class Solution { // tc is O(rows x cols) and sc is O(cols)
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int maxArea = 0;
        int n = matrix[0].length;
        int[] heights = new int[n];

        for(char[] row:matrix){
            for(int j = 0;j<n;j++){
                // Build histogram: increase if '1', reset to 0 if '0'
                heights[j] = row[j] == '1' ? heights[j] + 1: 0;
            }
                maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights ){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Add a 0 at the end to flush remaining heights
        int[] extended = new int[n + 1];
        System.arraycopy(heights, 0, extended, 0, n);

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || extended[i] < extended[stack.peek()])) {
                int height = extended[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}