public class ProblemNo3336 {
    public static void main(String[] args) {

    }

    class Solution {

        private final static int MOD = 1_000_000_007;

        public int subsequencePairCount(int[] nums) {

            int M = 0;
            for (int num : nums) {
                M = Math.max(M, num);
            }
            int[][] dp = new int[M + 1][M + 1];
            dp[0][0] = 1;

            for (int num : nums) {
                int[][] newDP = new int[M + 1][M + 1];

                for (int i = 0; i <= M; i++) {
                    int seq1GCD = GCD(i, num);

                    for (int j = 0; j <= M; j++) {
                        int val = dp[i][j];

                        if (val == 0) continue;

                        int seq2GCD = GCD(j, num);
                        newDP[i][j] = (newDP[i][j] + val) % MOD;
                        newDP[seq1GCD][j] = (newDP[seq1GCD][j] + val) % MOD;
                        newDP[i][seq2GCD] = (newDP[i][seq2GCD] + val) % MOD;
                    }
                }

                dp = newDP;

            }

            int count = 0;

            for (int i = 1; i <= M; i++) {
                count = (dp[i][i] + count) % MOD;
            }

            return count;
        }

        private int GCD(int a, int b) {
            while (b != 0) {
                int temp = a;
                a = b;
                b = temp % b;
            }

            return a;
        }
    }

}
