class LFUCache { // tc is O(1) and sc is O(n)
    class Node{
        int freq,key,value;
        Node(int key,int value){
            this.freq = 1;
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private int minFreq;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys; 

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;
        Node node = keyToNode.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // if already their means jsut updateFrequency
        if(capacity == 0) return ;

        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);
            node.value = value;
            updateFrequency(node);
        }else{ // if it is not thier means just have 
if (keyToNode.size() == capacity) {
                // Remove least frequently used key
                LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
                int evictKey = keys.iterator().next();
                keys.remove(evictKey);
                if (keys.isEmpty()) {
                    freqToKeys.remove(minFreq);
                }
                keyToNode.remove(evictKey);
            }

            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            freqToKeys.computeIfAbsent(1, ignore -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
        }
        private void updateFrequency(Node node) {
        int freq = node.freq;
        LinkedHashSet<Integer> keys = freqToKeys.get(freq);
        keys.remove(node.key);
        if (keys.isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }

        node.freq++;
        freqToKeys.computeIfAbsent(node.freq, ignore -> new LinkedHashSet<>()).add(node.key);
    }
    }


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */