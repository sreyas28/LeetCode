public class ProblemNo1872 {

    public static void main(String[] args) {

        Solution a = new ProblemNo1872().new Solution();
        System.out.println(a.stoneGameVIII(new int[]{-1, 2, -3, 4, -5}));
        System.out.println(a.stoneGameVIII(new int[]{7, -6, 5, 10, 5, -2, -6}));
        System.out.println(a.stoneGameVIII(new int[]{-10, -12}));

    }

    class Solution {
        public int stoneGameVIII(int[] stones) {
            final int N = stones.length;
            int[] prefixSums = new int[N];
            prefixSums[0] = stones[0];

            for (int i = 1; i < N; i++) prefixSums[i] = prefixSums[i - 1] + stones[i];

            int[] dp = new int[N];
            dp[N - 1] = prefixSums[N - 1];

            for (int i = N - 2; i >= 1; i--) {
                dp[i] = Math.max(dp[i+1], prefixSums[i] - dp[i+1]);
            }

            return dp[1];
        }
    }

    // Wrong
    class Solution_ {
        public int stoneGameVIII(int[] stones) {
            final int N = stones.length;
            int[] prefixSums = new int[N + 1];

            for (int i = 1; i <= N; i++) prefixSums[i] = prefixSums[i - 1] + stones[i - 1];

            int[][][] DP = new int[N - 1][N + 1][2];

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 2; j <= N; j++) {
                    if (i == 0) {
                        DP[i][j][0] = prefixSums[j];
                        continue;
                    }

                    int[] A = {DP[i - 1][j - 1][0], prefixSums[j]};
                    int[] B = DP[i - 1][j];

                    int diffA = Math.abs(A[0] - A[1]);
                    int diffB = Math.abs(B[0] - B[1]);

                    DP[i][j] = diffA >= diffB ? A : B;
                }
            }

            return DP[N - 2][N][0] - DP[N - 2][N][1];
        }
    }


}
