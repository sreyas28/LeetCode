import java.util.*;

public class ProblemNo138 {
    public static void main(String[] args) {
        Node root = new Node(7);
        root.next = new Node(13);
        root.next.next = new Node(11);
        root.next.next.next = new Node(10);
        root.next.next.next.next = new Node(1);

        root.random = null;
        root.next.random = root;
        root.next.next.random = root.next.next.next.next;
        root.next.next.next.random = root.next.next;
        root.next.next.next.next.random = root;
        new Node(0).print(root);

        System.out.println();

        Solution a = new ProblemNo138().new Solution();
        new Node(0).print(a.copyRandomList(root));

    }

    class Solution {

        private Map<Node, Node> map;

        public Node copyRandomList(Node head) {
            this.map = new HashMap<>(); // older to newer
            Node newHead = maker(head);

            for (Node older : this.map.keySet()) {
                Node newer = this.map.get(older);

                if (older.random == null) continue;
                newer.random = map.get(older.random);
            }

            return newHead;
        }

        private Node maker(Node head) {
            if (head == null) return null;

            Node cur = new Node(head.val);
            cur.next = maker(head.next);

            map.put(head, cur);

            return cur;
        }


    }

}
