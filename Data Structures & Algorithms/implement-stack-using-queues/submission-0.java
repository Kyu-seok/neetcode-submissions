class MyStack {

    List<Integer> queue1;
    List<Integer> queue2;

    public MyStack() {
        this.queue1 = new ArrayList<>();
        this.queue2 = new ArrayList<>();
    }
    
    public void push(int x) {
        queue1.addLast(x);
    }
    
    public int pop() {
        if (empty()) return -1;
        while (queue1.size() > 1) {
            queue2.addLast(queue1.removeFirst());
        }

        int popValue = queue1.removeFirst();

        queue1 = queue2;
        queue2 = new ArrayList<>();

        return popValue;
    }
    
    public int top() {
        if (empty()) return -1;

        while (queue1.size() > 1) {
            queue2.addLast(queue1.removeFirst());
        }

        int topValue = queue1.getFirst();
        queue2.addLast(queue1.removeFirst());
        queue1 = queue2;
        queue2 = new ArrayList<>();

        return topValue;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */