import java.util.*;

public class ProblemNo3217 {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode modifiedList(int[] nums, ListNode head) {

            Set<Integer> numss = new HashSet<>();
            for(int i: nums) numss.add(i);

            ListNode resultHead = new ListNode();
            ListNode current = resultHead;

            while(head != null){
                if(!numss.contains(head.val)){
                    current.next = head;
                    current = current.next;
                }
                head = head.next;
            }
            current.next = null;

            return resultHead.next;
        }
    }

}
