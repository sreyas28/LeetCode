public class ProblemNo61 {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution a = new ProblemNo61().new Solution();
        System.out.println(a.rotateRight(node1, 2));

    }


    // just code
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null) return head;
            int n = getLength(head);
            k = k % n;

            if (k == 0) return head;

            k = n - k;

            int count = 0;
            ListNode cur = head;
            while (count != k - 1) {
                cur = cur.next;
                count++;
            }

            ListNode res = cur.next;
            ListNode temp = cur.next;
            cur.next = null;

            while (temp.next != null) temp = temp.next;
            temp.next = head;

            return res;
        }

        private int getLength(ListNode head) {
            if (head == null) return 0;

            int count = 0;
            while (head != null) {
                head = head.next;
                count++;
            }
            return count;
        }

    }

}
