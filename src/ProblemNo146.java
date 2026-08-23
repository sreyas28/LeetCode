import java.util.HashMap;
import java.util.Map;

public class ProblemNo146 {

    class LRUCache {
        private class ListNode {
            int key;
            int val;

            ListNode prev;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
                this.prev = null;
                this.next = null;
            }
        }

        private final Map<Integer, ListNode> map;
        private ListNode head;
        private final ListNode tail;
        private final int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            this.capacity = capacity;

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            update(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.get(key).val = value;
                update(key);
                return;
            }
            while (map.size() >= capacity) delete();

            ListNode A = new ListNode(key, value);
            A.prev = tail.prev;
            A.next = tail;
            tail.prev.next = A;
            tail.prev = A;

            map.put(key, A);
        }

        private void update(int key){
            ListNode A = map.get(key);
            A.prev.next = A.next;
            A.next.prev = A.prev;

            A.prev = tail.prev;
            A.next = tail;
            tail.prev.next = A;
            tail.prev = A;
        }

        private void delete(){
            ListNode last = head.next;

            map.remove(last.key);
            head = head.next;
            head.prev = null;
        }

    }

}
