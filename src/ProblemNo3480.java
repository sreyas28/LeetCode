public class ProblemNo3480 {
    public static void main(String[] args) {

    }

    class Solution {
        public long maxSubarrays(int n, int[][] conflictingPairs) {
            long total = ((long) n * (n+1)) / 2;
            long remaining = (long) (Math.pow(2, conflictingPairs.length - 1) - 1);

            return total - remaining;
        }
    }

}
