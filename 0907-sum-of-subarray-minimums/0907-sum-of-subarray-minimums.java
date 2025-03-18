class Solution { // tc is o(n) and sc is O(n)
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        final int MOD = 1000000007;

       int[] ple = new int[n];// prevoius ele
       int[] nle = new int[n];// next ele

       Stack<Integer> stack = new Stack<>();

       // ple
       for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            ple[i] = stack.isEmpty() ? (i + 1) : (i-stack.peek());
            stack.push(i);
       }
       // we have to clear the stack

       stack.clear();

       //nle
       for(int i = n-1 ;i>=0;i--){
        while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
            stack.pop();
        }
        nle[i] = stack.isEmpty() ? (n-i):(stack.peek()-i);
        stack.push(i);
       }

       for(int i = 0;i<n;i++){
            totalSum = (totalSum + (long)arr[i] * ple[i] * nle[i] ) % MOD;
       }
       return (int) totalSum;

    }
}