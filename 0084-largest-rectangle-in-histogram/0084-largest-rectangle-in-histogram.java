class Solution { // tc is O(3N) but constanst will be ignore O(N) and sc is O(N)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n]; // this is for an pse elements
        int[] right = new int[n];// this is for an nse elements

        Stack<Integer> stack = new Stack<>();
        // step1: finding out an pse elements
        for(int i = 0;i<n;i++){ // tc is O(N)
            while(!stack.isEmpty()&& heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();// if no smaller element, assign -1
            stack.push(i);
        }
        stack.clear();
        // step2: finding out an nse elements

        for(int i = n-1;i>=0;i--){// tc is O(N)
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        // Step 3: Compute max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {// tc is O(N)
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}