class MinStack {
        Deque<Integer> st;
        Deque<Integer> minInt;

    public MinStack() {
        st = new ArrayDeque<>();
        minInt = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minInt.isEmpty() || minInt.peek() > val){
            minInt.push(val);
        } else {
            minInt.push(minInt.peek());
        }
    }
    
    public void pop() {
        st.pop();
        minInt.pop();   
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minInt.peek();
    }
}
