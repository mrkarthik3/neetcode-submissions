class MinStack {

    ArrayDeque<Integer> normalStack;
    ArrayDeque<Integer> minStack;

    public MinStack() {
        this.normalStack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(this.normalStack.size() == 0){
            this.normalStack.push(val);
            this.minStack.push(val);
        }else {
            this.normalStack.push(val);
            int min = this.minStack.peek();
            if(min < val){
                this.minStack.push(min);
            } else{
                this.minStack.push(val);
            }
        }
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
