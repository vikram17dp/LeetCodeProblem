class MinStack { // tc is O(1) and sc is O(2N)
    private Stack<Pair<Integer, Integer>> st;
    public MinStack() {
       st = new Stack<>();  
    }
    
    public void push(int val) {
        if(st.isEmpty()){
           st.push(new Pair<>(val, val));
        }else{
            st.push(new Pair<>(val,Math.min(val,st.peek().getValue())));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
       return st.peek().getKey();
    }
    
    public int getMin() {
        return st.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */