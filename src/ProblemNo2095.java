public class ProblemNo2095 {
    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        Solution a = new ProblemNo2095().new Solution();
        System.out.println(a.deleteMiddle(head));

    }

    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            if (head.next == null) return null;

            ListNode slowPrev = null;
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slowPrev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            if (slow == head) slow.next = null;
            else if (fast.next != null) {
                slowPrev = slow;
                slow = slow.next;

                slowPrev.next = slow.next;
            }
            else slowPrev.next = slow.next;


            return head;
        }
    }

}
