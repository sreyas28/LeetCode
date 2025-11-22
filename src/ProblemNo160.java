public class ProblemNo160 {
    public static void main(String[] args) {

    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;

            ListNode tempA = headA, tempB = headB;

            while (tempA != tempB) {
                tempA = (tempA == null) ? headB : tempA.next;
                tempB = (tempB == null) ? headA : tempB.next;
            }

            return tempA; // either intersection node or null
        }
    }
}
