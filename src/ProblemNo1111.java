public class ProblemNo1111 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int balance = 0;

            int[] result = new int[seq.length()];

            for (int i = 0; i < seq.length(); i++) {
                if (seq.charAt(i) == '(') {
                    balance++;
                    result[i] = balance % 2 == 0 ? 0 : 1;
                }
                else {
                    result[i] = balance % 2 == 0 ? 0 : 1;
                    balance--;
                }
            }

            return result;
        }
    }

}
