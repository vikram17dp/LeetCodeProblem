class StockSpanner { // tc is O(N) and sc is O(N)
    Stack<int[]> stack; // [price, span]

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Merge spans while the current price is >= stack's top price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Accumulate the span
        }

        // Push current price and span
        stack.push(new int[]{price, span});

        return span;
    }
}
