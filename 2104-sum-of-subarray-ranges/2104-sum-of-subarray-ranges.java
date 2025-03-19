// tc is O(n) + O(n) + O(n) + O(n) [for four operations] + O(n)[stack operations] = o(5n)=>o(n)
// sc is O(n) + O(n) + O(n) + O(n) [for four operations] + O(n)[stack operations] = o(5n)=>o(n)
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        // smaller 
        int[] ple = new int[n];
        int[] nle = new int[n];
        // greater
        int[] pge = new int[n];
        int[] nge = new int[n];

        Stack<Integer> stack = new Stack<>();

        // ple
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? (i+1) : (i-stack.peek());
            stack.push(i);
        }
        // we have to clear the stack
        stack.clear();

        // nle

        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? (n-i) : (stack.peek() -i);
            stack.push(i);
        }
        // compute minimum sum
        for(int i = 0;i<n;i++){
            sum -= (long) nums[i]*ple[i]*nle[i];
        }
        stack.clear();
        // pge

        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? (i+1) : (i-stack.peek());
            stack.push(i);
        }
        stack.clear();

        // nge

        for(int i= n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? (n-i) : (stack.peek() -i);
            stack.push(i);
        }
        // compute minimum sum
        for(int i = 0;i<n;i++){
            sum += (long) nums[i]*pge[i]*nge[i];
        }
        return sum;

    }
}