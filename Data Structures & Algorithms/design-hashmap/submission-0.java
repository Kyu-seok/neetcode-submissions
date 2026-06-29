class MyHashMap {

    Integer[] arr;

    public MyHashMap() {
        this.arr = new Integer[1_000_001];
    }
    
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    public int get(int key) {
        if (arr[key] == null) return -1;
        return arr[key];
    }
    
    public void remove(int key) {
        arr[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */