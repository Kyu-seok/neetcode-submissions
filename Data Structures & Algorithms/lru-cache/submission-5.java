class LRUCache {

    int capacity;
    Node lruDummy;
    Node mruDummy;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruDummy = new Node(-1, -1);
        this.mruDummy = new Node(-1, -1);

        lruDummy.next = mruDummy;
        mruDummy.prev = lruDummy;

        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return - 1;
        }

        Node node = cache.get(key);
        moveToMRU(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.value = value;
            moveToMRU(node);
            return;
        }

        if (cache.size() == capacity) {
            removeLRU();
        }

        Node newNode = new Node(key, value);

        insertToMRU(newNode);
        cache.put(key, newNode);
    }

    private void removeLRU() {
        Node lru = lruDummy.next;
        unlink(lru);
        cache.remove(lru.key);
    }

    private void moveToMRU(Node node) {
        unlink(node);
        insertToMRU(node);
    }

    private void insertToMRU(Node node) {
        mruDummy.prev.next = node;
        node.prev = mruDummy.prev;
        node.next = mruDummy;
        mruDummy.prev = node;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
