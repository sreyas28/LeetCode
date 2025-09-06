import java.util.PriorityQueue;

public class ProblemNo3495 {
    public static void main(String[] args) {
        ProblemNo3495.Solution a = new ProblemNo3495().new Solution();
        System.out.println(a.minOperations(new int[][]{
                {1,10}
        }));
    }

    class Solution_1 {
        public long minOperations(int[][] queries) {
            long totalOps = 0;

            for (int[] range : queries) {
                int l = range[0], r = range[1];
                long steps = 0;

                for (int k = 0; ; k++) {
                    long low = (long) Math.pow(4, k);
                    long high = (long) Math.pow(4, k + 1) - 1;

                    if (low > r) break;

                    long from = Math.max(low, l);
                    long to = Math.min(high, r);

                    if (from <= to) {
                        long count = to - from + 1;
                        steps += count * (k + 1);
                    }
                }

                totalOps += (long) Math.ceil((double) steps / 2);
            }

            return totalOps;
        }
    }

    class Solution {
        public long minOperations(int[][] queries) {
            // Precompute powers of 4 up to 4^15 (~10^9)
            long[] powers = new long[16];
            powers[0] = 1;
            for (int i = 1; i < powers.length; i++) {
                powers[i] = powers[i - 1] * 4;
            }

            long totalOps = 0;

            for (int[] range : queries) {
                int l = range[0], r = range[1];
                long steps = 0;

                for (int k = 0; k < powers.length - 1; k++) {
                    long from = Math.max(powers[k], l);
                    long to = Math.min(powers[k + 1] - 1, r);

                    if (from <= to) {
                        long count = to - from + 1;
                        steps += count * (k + 1);
                    }
                }

                totalOps += (steps + 1) / 2; // ceil(steps / 2)
            }

            return totalOps;
        }
    }

}
