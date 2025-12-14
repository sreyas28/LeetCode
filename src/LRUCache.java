import java.util.*;

class LRUCache {

    private class CacheNode{
        int key;
        int value;
        CacheNode next = null;
        CacheNode prev = null;

        public CacheNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, CacheNode> nodes;
    int capacity;
    CacheNode head;
    CacheNode tail;

    public LRUCache(int capacity) {
        nodes = new HashMap<>();
        this.capacity = capacity;

        head = new CacheNode(0,0);
        tail = new CacheNode(0,0);
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if(!nodes.containsKey(key)) return -1;

        CacheNode c = nodes.get(key);

        // breaking the link
        c.prev.next = c.next;
        c.next.prev = c.prev;

        //joining it to the head;
        c.next = head.next;
        head.next.prev = c;
        head.next = c;
        c.prev = head;

        return c.value;
    }

    public void put(int key, int value) {

        if(nodes.containsKey(key)){
            nodes.get(key).value = value;

            CacheNode c = nodes.get(key);

            // breaking the link
            c.prev.next = c.next;
            c.next.prev = c.prev;

            //joining it to the head;
            c.next = head.next;
            head.next.prev = c;
            head.next = c;
            c.prev = head;

        }

        else if(nodes.size() < capacity){
            CacheNode c = new CacheNode(key, value);
            nodes.put(key, c);

            c.next = head.next;
            head.next.prev = c;
            head.next = c;
            c.prev = head;
        }

        else {
            CacheNode temp = tail.prev;
            int keyTemp = temp.key;

            //removing node
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            nodes.remove(keyTemp);

            temp.key = key;
            temp.value = value;

            //joining it to the head;
            temp.next = head.next;
            head.next.prev = temp;
            head.next = temp;
            temp.prev = head;

            nodes.put(key, temp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */