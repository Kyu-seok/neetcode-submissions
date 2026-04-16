class MinStack {

    List<Integer> list;
    Map<Integer, Integer> prevMinMap;
    int currMin = Integer.MAX_VALUE;

    public MinStack() {
        this.prevMinMap = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if (val < currMin) {
            prevMinMap.put(val, currMin);
            currMin = val;
        }
    }
    
    public void pop() {
        int pop = list.remove(list.size() - 1);
        if (pop == currMin) {
            currMin = prevMinMap.get(pop);
            prevMinMap.remove(pop);
        }
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return currMin;
    }
}
