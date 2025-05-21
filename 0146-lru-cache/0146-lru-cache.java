class LRUCache { // tc is 0(1) and sc is o(capacity)
    class Node{
        int key,value;
        Node next,prev;
        Node(int key,int value){
            this.key =key;
            this.value = value;
        }
    }
    private final int capacity;
    private final HashMap<Integer,Node> map;
    private final Node head,tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);// dummy head
        tail = new Node(0,0); // dummy tail
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insertToFront(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);  // remove least recently used
        }
        insertToFront(new Node(key, value));
    }
     private void insertToFront(Node node) {
        map.put(node.key, node);
        
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        map.remove(node.key);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */