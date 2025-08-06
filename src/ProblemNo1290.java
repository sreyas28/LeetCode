public class ProblemNo1290 {
    public static void main(String[] args) {

    }

    class Solution {
        public int getDecimalValue(ListNode head) {
            int deci = 0;

            while(head.next != null){
                deci = deci * 2 + head.val;

                head = head.next;
            }

            return deci;
        }
    }

}
