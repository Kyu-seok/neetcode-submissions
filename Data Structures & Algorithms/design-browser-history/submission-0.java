class BrowserHistory {

    List<String> list;
    int curr = -1;
    int last = -1;

    public BrowserHistory(String homepage) {
        this.list = new ArrayList<>();
        list.add(homepage);
        this.curr = 0;
        this.last = curr;
    }
    
    public void visit(String url) {
        if (curr == last) {
            list.add(url);
        } else {
            list.set(curr + 1, url);
        }
        curr++;
        last = curr;
    }
    
    public String back(int steps) {
        int index = Math.max(0, curr - steps);

        curr = index;
        return list.get(curr);
    }
    
    public String forward(int steps) {
        int index = Math.min(last, curr + steps);
        curr = index;
        return list.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */