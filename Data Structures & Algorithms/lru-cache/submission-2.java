class LRUCache {

    Map<Integer, Node> cache;
    int capacity;

    Node lruDummy;
    Node mruDummy;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;

        this.lruDummy = new Node(-1, -1);
        this.mruDummy = new Node(-1, -1);

        lruDummy.next = mruDummy;
        mruDummy.prev = lruDummy;
    }
    
    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) return -1;

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
            Node rlu = lruDummy.next;
            unlink(rlu);
            cache.remove(rlu.key);
        }

        Node newNode = new Node(key, value);
        insertMRU(newNode);
        cache.put(key, newNode);
    }

    private void moveToMRU(Node node) {
        unlink(node);
        insertMRU(node);
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertMRU(Node node) {
        mruDummy.prev.next = node;
        node.prev = mruDummy.prev;
        node.next = mruDummy;
        mruDummy.prev = node;
    }

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
