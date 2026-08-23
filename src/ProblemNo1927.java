public class ProblemNo1927 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean sumGame(String num) {
            int[] firstHalf = getValues(num.substring(0, num.length() / 2));
            int[] secondHalf = getValues(num.substring(num.length() / 2));

            int q0 = firstHalf[0];
            int q1 = secondHalf[0];

            int n0 = firstHalf[1];
            int n1 = secondHalf[1];

            return (q0 + q1) % 2 == 1 || (n0 - n1) != 4.5 * (q1 - q0);
        }

        private int[] getValues(String num) {
            int q = 0, sum = 0;

            for (char c : num.toCharArray()) {
                if (c == '?') q++;
                else sum += (c - '0');
            }

            return new int[]{q, sum};
        }

    }

}
