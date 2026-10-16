// Per the assumption in the problem description
// pop, top and getMin will always be called on non-empty stacks.
class MinStack {

    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.offerLast(val);
        int min = minStack.isEmpty() ? val : Math.min(this.getMin(), val);
        minStack.offerLast(min);
    }
    
    public void pop() {
        stack.pollLast();
        minStack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}
