// per the problem description, pop and peek operations will be valid
class MyQueue {

    private final Deque<Integer> inStack;
    private final Deque<Integer> outStack;

    public MyQueue() {
        this.inStack = new ArrayDeque<>();
        this.outStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        this.inStack.offerLast(x);
    }
    
    public int pop() {
        // per the description, empty won't happen then
        this.pourOver();
        return outStack.pollLast();
    }
    
    public int peek() {
        this.pourOver();
        return outStack.peekLast();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void pourOver() {
        if (!outStack.isEmpty()) {
            return;
        }

        while(!this.inStack.isEmpty()) {
            this.outStack.offerLast(this.inStack.pollLast());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */