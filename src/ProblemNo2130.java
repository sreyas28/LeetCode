import java.util.ArrayList;
import java.util.List;

public class ProblemNo2130 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution a = new ProblemNo2130().new Solution();
        System.out.println(a.pairSum(head));

    }

    class Solution {
        public int pairSum(ListNode head) {

            List<Integer> list = new ArrayList<>();

            ListNode fast = head;
            ListNode slow = head;
            list.add(slow.val);

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                list.add(slow.val);
            }

            slow = slow.next;
            int a = list.size() -1;
            int res = 0;
            while(slow != null) {
                res =Math.max(res,slow.val + list.get(a--));
                slow = slow.next;
            }


            return res;
        }
    }

}
