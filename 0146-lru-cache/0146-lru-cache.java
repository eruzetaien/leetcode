class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insertToHead(node);
            node.value = value;
        } else {
            Node newNode = new Node(key, value);
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            map.put(key,newNode);
            if (map.size() > capacity){
                Node removedNode = tail.prev;
                map.remove(removedNode.key);
                remove(removedNode);
            }
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */