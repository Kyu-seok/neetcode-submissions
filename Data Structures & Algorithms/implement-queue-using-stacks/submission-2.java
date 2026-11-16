class MyQueue {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public MyQueue() {
        this.stackA = new Stack<>();
        this.stackB = new Stack<>();
    }
    
    public void push(int x) {
        stackA.push(x);
    }
    
    public int pop() {
        while (stackA.size() > 1) {
            stackB.push(stackA.pop());
        }

        int res = stackA.pop();

        while (!stackB.isEmpty()) {
            stackA.push(stackB.pop());
        }

        return res;
    }
    
    public int peek() {
        while (stackA.size() > 1) {
            stackB.push(stackA.pop());
        }

        int res = stackA.peek();

        while (!stackB.isEmpty()) {
            stackA.push(stackB.pop());
        }

        return res;
    }
    
    public boolean empty() {
        return stackA.size() == 0;
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