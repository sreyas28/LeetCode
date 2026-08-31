import java.util.*;

public class ProblemNo2058 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);

        Solution a = new ProblemNo2058().new Solution();
        System.out.println(Arrays.toString(a.nodesBetweenCriticalPoints(head)));


    }

    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            List<Integer> list = new ArrayList<>();

            ListNode prev = head, curr = head.next;
            int idx = 1;

            while (curr != null && curr.next != null) {
                int currVal = curr.val, prevVal = prev.val, nextVal = curr.next.val;

                if (currVal > prevVal && currVal > nextVal) list.add(idx);
                else if (currVal < prevVal && currVal < nextVal) list.add(idx);

                prev = curr;
                curr = curr.next;
                idx++;
            }

            if (list.size() <= 1) return new int[]{-1, -1};

            int[] result = {list.get(1) - list.get(0), list.getLast() - list.get(0)};

            for (int i = 1; i < list.size(); i++) {
                result[0] = Math.min(result[0], list.get(i) - list.get(i - 1));
            }

            return result;
        }
    }

}
