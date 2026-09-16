import java.util.ArrayList;
import java.util.Arrays;

public class ProblemNo1621 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1621().new Solution();
        System.out.println(a.numberOfSets(4, 2));
        System.out.println(a.numberOfSets(3, 1));
        System.out.println(a.numberOfSets(30, 7));

    }

    class Solution {
        public int numberOfSets(int n, int k) {
            final int MOD = 1_000_000_007;
            int[][] memo = new int[k+1][n+1];

            Arrays.fill(memo[0], 1);

            for (int aK = 1; aK <= k; aK++) {
                int[] prev = new int[n+1];
                prev[n] = memo[aK-1][n];
                for (int x = n-1; x >= 0; x--) prev[x] = (memo[aK-1][x] + prev[x+1]) % MOD;

                for (int i = n-1; i >= 0; i--) {
                    int count = memo[aK][i+1];
                    count = (count + prev[i+1]) % MOD;

                    memo[aK][i] = count;
                }
            }

            return memo[k][1];
        }
    }

    // good but not for 1000, 999
    class Solution_ {
        private final int MOD = (int) (1e9 + 7);
        private Integer[][] memo;

        public int numberOfSets(int n, int k) {
            this.memo = new Integer[n + 1][k + 1];

            return solve(n, k, 0);
        }

        private int solve(int n, int k, int i) {
            if (k <= 0) return 1;
            else if (i == n) return 0;

            if (memo[i][k] != null) return memo[i][k];

            long count = 0;

            // skip
            count = (count + solve(n, k, i + 1)) % MOD;

            // take
            for (int j = i + 1; j < n; j++) count = (count + solve(n, k - 1, j)) % MOD;


            memo[i][k] = (int) (count % MOD);
            return memo[i][k];
        }
    }

}
