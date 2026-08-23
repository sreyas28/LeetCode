public class ProblemNo2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);
        node1.next.next.next = new ListNode(9);

        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(9);
        node2.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next = new ListNode(9);

        Solution a = new ProblemNo2().new Solution();
        new ListNode().print(a.addTwoNumbers(node2, node1));

    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            generate(l1, l2, 0);
            return l1;
        }

        private void generate(ListNode l1, ListNode l2, int carry) {
            int val = l1.val + carry + (l2 == null ? 0 : l2.val);
            l1.val = val % 10;
            carry = val / 10;


            if (l1.next != null) generate(l1.next, (l2 == null ? null : l2.next), carry);
            else if (l2 != null && l2.next != null) {
                l1.next = l2.next;
                generate(l1.next, null, carry);
            } else if (carry > 0) l1.next = new ListNode(carry);
        }

    }

}
