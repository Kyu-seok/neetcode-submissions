class LRUCache {

    int capacity;
    Map<Integer, Node> cache;
    Node lruDummy;
    Node mruDummy;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lruDummy = new Node(-1, -1);
        this.mruDummy = new Node(-1, -1);
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

        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToMru(node);
            return;
        }

        if (cache.size() == capacity) {
            Node lru = lruDummy.next;
            unlink(lru);
            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        insertToMru(newNode);
        cache.put(key, newNode);
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

    class Node {
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
