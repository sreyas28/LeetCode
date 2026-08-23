public class ProblemNo206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode H = new ListNode(0);
            H.next = head;

            // H -> D -> ... -> C -> A -> B

            ListNode C = head;
            while( C != null && C.next != null) {
                ListNode D = H.next;
                ListNode A = C.next;
                ListNode B = C.next.next;

                H.next = A;
                A.next = D;
                C.next = B;
            }

            return H.next;
        }
    }

}
