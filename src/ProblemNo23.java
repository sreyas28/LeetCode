public class ProblemNo23 {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = null;
            for(ListNode list : lists) {
                res = merge(res, list);
            }

            return res;
        }

        private ListNode merge(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) return null;
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            ListNode head = null;
            if (list1.val >= list2.val) {
                head = new ListNode(list2.val);
                head.next = merge(list1, list2.next);
            } else {
                head = new ListNode(list1.val);
                head.next = merge(list1.next, list2);
            }

            return head;
        }
    }

}
