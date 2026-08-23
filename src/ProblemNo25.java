public class ProblemNo25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);


        Solution a = new ProblemNo25().new Solution();
        new ListNode().print(a.reverseKGroup(head, 3));
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) return head;

            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                length++;
                temp = temp.next;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            int times = length / k;

            ListNode H = dummy; // home sweet home
            ListNode C = dummy.next;


            while (times > 0) {
                int doIt = k-1;

                // H -> D -> ... -> C -> A -> B
                while (doIt > 0) {
                    ListNode D = H.next;
                    ListNode A = C.next;
                    ListNode B = C.next.next;

                    H.next = A;
                    A.next = D;
                    C.next = B;

                    doIt--;
                }

                H = C;
                C = C.next;

                times--;
            }

            return dummy.next;
        }
    }

}

