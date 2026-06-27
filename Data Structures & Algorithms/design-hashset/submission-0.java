class MyHashSet {

    boolean[] bucket;

    public MyHashSet() {
        this.bucket = new boolean[1_000_001];
    }
    
    public void add(int key) {
        bucket[key] = true;
    }
    
    public void remove(int key) {
        bucket[key] = false;
    }
    
    public boolean contains(int key) {
        return bucket[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */