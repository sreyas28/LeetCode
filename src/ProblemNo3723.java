public class ProblemNo3723 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3723().new Solution();
        System.out.println(a.maxSumOfSquares(2,3));
    }

    class Solution {
        public String maxSumOfSquares(int num, int sum) {

            if (sum > 9 * num) {
                return "";
            }

            int rem = sum % 9;
            int nines = sum / 9;

            StringBuilder sb = new StringBuilder();
            sb.repeat("9", Math.max(0, nines));

            if(rem > 0) sb.append(rem);

            int remPositions = num - sb.length();
            sb.repeat("0", Math.max(0, remPositions));

            return sb.toString();
        }

    }

}
