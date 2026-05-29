class MinStack {
    // Implementing MinStack via 2 stacks algo is a new one.
    // Learn and memorize it.
    // Can use just one stack if it store array of len = 2 or a HashMap 
    // That array/HashMap can store current and min.
    // But that wont improve the O(1) TC for all operations and O(n) Space
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
