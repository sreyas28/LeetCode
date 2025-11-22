public class ProblemNo234 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode half = half(head);
            ListNode reversed = reverse(half);

            while(head != null && reversed != null){
                if (head.val != reversed.val) return false;

                head = head.next;
                reversed = reversed.next;
            }

            return true;
        }

        private ListNode half(ListNode head){
            ListNode slow = head, fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverse (ListNode head){
            ListNode temp = head, curr = head, prev = null;

            while(temp != null){
                temp = temp.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            return prev;
        }
    }

}
