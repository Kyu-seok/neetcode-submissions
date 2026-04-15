class MinStack {

    List<Integer> list;
    List<Integer> minList;
    int currentMin = Integer.MAX_VALUE;

    public MinStack() {
        this.list = new ArrayList<>();
        this.minList = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if (val < currentMin) {
            currentMin = val;
        } 
        minList.add(currentMin);
    }
    
    public void pop() {
        list.remove(list.size() - 1);
        minList.remove(minList.size() - 1);
        if (!minList.isEmpty()) {
            currentMin = minList.get(minList.size() - 1);
        } else {
            currentMin = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return currentMin;
    }
}
