class LRUCache {

    int capacity;
    Node lruDummy;
    Node mruDummy;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruDummy = new Node(-1, -1);
        this.mruDummy = new Node(-1, -1);
        this.map = new HashMap<>();

        lruDummy.next = mruDummy;
        mruDummy.prev = lruDummy;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        moveToMRU(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            moveToMRU(node);
            return;
        }

        if (map.size() == capacity) {
            removeLRU();
        }

        Node newNode = new Node(key, value);

        insertToMRU(newNode);
        map.put(newNode.key, newNode);
    }

    private void removeLRU() {
        Node lru = lruDummy.next;
        unlink(lru);
        map.remove(lru.key);
    }

    private void moveToMRU(Node node) {
        unlink(node);
        insertToMRU(node);
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToMRU(Node node) {
        mruDummy.prev.next = node;
        node.prev = mruDummy.prev;
        node.next = mruDummy;
        mruDummy.prev = node;
    }

    class Node {
        Node next;
        Node prev;

        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
