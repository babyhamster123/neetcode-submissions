class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1;
        }

        promote(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.val = value;
            promote(n);
            return;
        }

        n = new Node(key, value);
        map.put(key, n);
        append(n);

        if (map.size() > capacity) {
            Node oldest = head.next;
            unlink(oldest);
            map.remove(oldest.key);
        }
    }

    private void promote(Node n) {
        unlink(n);
        append(n);
    }

    private void unlink(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void append(Node n) {
        Node prev = tail.prev;
        n.prev = prev;
        n.next = tail;
        prev.next = n;
        tail.prev = n;
    }

    private static class Node {
        private final int key;
        private int val;
        private Node prev;
        private Node next;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}