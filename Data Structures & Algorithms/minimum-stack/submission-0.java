class MinStack {
    ArrayDeque<Integer> normalStack;
    ArrayDeque<Integer> minStack;

    public MinStack() {
        this.normalStack = new ArrayDeque<Integer>();
        this.minStack = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        this.normalStack.push(val);
        int min = val; // just assume for now
        // valid min will be calculated below
        if(this.minStack.size() == 0) {
            min = Math.min(min, val);
        } else {
            min = Math.min(this.minStack.peek(), val);
        }
        this.minStack.push(min);
        
    }
    
    public void pop() {
        this.minStack.pop();
        this.normalStack.pop();
    }
    
    public int top() {
        return this.normalStack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
