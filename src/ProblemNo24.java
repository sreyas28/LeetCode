public class ProblemNo24 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        Solution a = new ProblemNo24().new Solution();
        new ListNode().print(a.swapPairs(list1));
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            ListNode P = dummyHead;
            ListNode C = dummyHead.next.next;

            while (C != null) {
                ListNode A = P.next;
                ListNode B = C.next;

                // P -> A -> C -> B
                P.next = C;
                C.next = A;
                A.next = B;
                // P -> C -> A -> B

                P = A;
                C = (B != null && B.next != null) ? B.next : null;
            }

            return dummyHead.next;
        }
    }

}
