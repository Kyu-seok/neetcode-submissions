class MinStack {

    Deque<int[]> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.offerLast(new int[] {val, min});
        min = Math.min(min, val);
    }
    
    public void pop() {
        int[] arr = stack.pollLast();
        min = arr[1];
    }
    
    public int top() {
        return stack.peekLast()[0];
    }
    
    public int getMin() {
        return min;
    }
}
