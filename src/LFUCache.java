import java.util.*;

class LFUCache {
    private class Node{
        int key;
        int value;
        int freq = 1;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }

    Map<Integer, Node> NodeMap;
    TreeMap<Integer, LinkedList<Node>> FreqencyMap;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        NodeMap = new HashMap<>();
        FreqencyMap = new TreeMap<>();
    }

    public int get(int key) {
        if(!NodeMap.containsKey(key)) return -1;
        Node c = NodeMap.get(key);

        int freq = c.freq;
        c.freq++;

        FreqencyMap.get(freq).remove(c);
        if(FreqencyMap.get(freq).isEmpty()) FreqencyMap.remove(freq);

        FreqencyMap.computeIfAbsent(c.freq, a -> new LinkedList<>()).addFirst(c);

        return c.value;
    }

    public void put(int key, int value) {
        if(NodeMap.containsKey(key)){
            Node c = NodeMap.get(key);
            c.value = value;

            int freq = c.freq;
            c.freq++;

            FreqencyMap.get(freq).remove(c);
            if(FreqencyMap.get(freq).isEmpty()) FreqencyMap.remove(freq);

            FreqencyMap.computeIfAbsent(c.freq, a -> new LinkedList<>()).addFirst(c);
        }

        else if(NodeMap.size() < capacity){
            Node c = new Node(key, value);

            NodeMap.put(key, c);
            FreqencyMap.computeIfAbsent(1, a -> new LinkedList<>()).addFirst(c);
        }

        else{
            Node temp = FreqencyMap.get(FreqencyMap.firstKey()).removeLast();
            NodeMap.remove(temp.key);

            Node c = new Node(key,value);
            FreqencyMap.computeIfAbsent(1, a -> new LinkedList<>()).addFirst(c);
            NodeMap.put(key, c);
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */