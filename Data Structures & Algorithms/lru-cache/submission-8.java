class LRUCache {

    int capacity;
    Map<Integer, Node> cache;
    Node mruDummy;
    Node lruDummy;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.mruDummy = new Node(-1, -1);
        this.lruDummy = new Node(-1, -1);
        lruDummy.next = mruDummy;
        mruDummy.prev = lruDummy;
    }
    
    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) return -1;

        moveToMru(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existing = cache.get(key);
            existing.value = value;
            moveToMru(existing);
            return;
        }

        if (capacity == cache.size()) {
            removeLru();
        }

        Node node = new Node(key, value);

        cache.put(key, node);
        insertToMru(node);
    }

    private void moveToMru(Node node) {
        unlink(node);
        insertToMru(node);
    }

    private void unlink(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertToMru(Node node) {
        Node prevNode = mruDummy.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = mruDummy;
        mruDummy.prev = node;
    }

    private void removeLru() {
        Node lru = lruDummy.next;
        unlink(lru);
        cache.remove(lru.key);
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
