public class ProblemNo19 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);

        Solution a = new ProblemNo19().new Solution();
        new ListNode().print(a.removeNthFromEnd(l1, 1));
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int len = 0;

            ListNode dummy = head;
            while (dummy != null) {
                len++;
                dummy = dummy.next;
            }

            len = len - n;
            if (len == 0) return head.next;

            int dummyIdx = 0;
            ListNode prev = null;
            dummy = head;

            while (dummyIdx != len) {
                dummyIdx++;
                prev = dummy;
                if (dummy != null) dummy = dummy.next;
            }

            prev.next = dummy.next;
            return head;
        }
    }

}
