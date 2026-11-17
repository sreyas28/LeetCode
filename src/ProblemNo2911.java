import java.util.Arrays;

public class ProblemNo2911 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2911().new Solution();
        System.out.println(a.minimumChanges("aabbaa", 3));

    }

    class Solution {

        private static final int INF = 1_000_000;

        public int minimumChanges(String s, int k) {
            final int N = s.length();

            int[][] semiCosted = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = i; j < N; j++) {
                    semiCosted[i][j] = semiCost(s, i, j);
                }
            }


            int[][] dp = new int[N + 1][k + 1];
            for (int[] d : dp) Arrays.fill(d, INF);
            dp[N][0] = 0;

            for (int p = 1; p <= k; p++) {
                for (int suffixS = 0; suffixS < N; suffixS++) {
                    for (int x = suffixS; x < N; x++) {
                        if (dp[x + 1][p - 1] >= INF || semiCosted[suffixS][x] >= INF) continue;
                        dp[suffixS][p] = Math.min(dp[suffixS][p], dp[x + 1][p - 1] + semiCosted[suffixS][x]);
                    }
                }
            }


            return dp[0][k];
        }

        private int semiCost(String s, int start, int end) {
            int len = end - start + 1;
            if (len == 1) return INF;

            int best = INF;

            for (int d = 1; d < len; d++) {
                if (len % d != 0) continue;

                int changes = 0;
                for (int g = 0; g < d; g++) {
                    int l = start + g, r = start + g + ((len / d) - 1) * d;
                    while (l < r) {
                        if (s.charAt(l) != s.charAt(r)) changes++;
                        l += d;
                        r -= d;
                    }
                }

                best = Math.min(best, changes);
            }

            return best;
        }

    }

}
