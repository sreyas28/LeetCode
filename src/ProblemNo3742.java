import java.util.Arrays;

public class ProblemNo3742 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3742().new Solution();
        System.out.println(a.maxPathScore(new int[][]{{0, 1}, {2, 0}}, 1));

    }

    class Solution {
        public int maxPathScore(int[][] grid, int k) {
            final int m = grid.length, n = grid[0].length;

            int[][][] dp = new int[m][n][k + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], Integer.MIN_VALUE);
                }
            }

            dp[0][0][0] = 0;

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    for (int cost = 0; cost <= k; cost++) {
                        if (dp[row][col][cost] == Integer.MIN_VALUE) continue;

                        if (row + 1 < m) {
                            int score = grid[row + 1][col];
                            int cCost = score == 0 ? 0 : 1;

                            if (cost + cCost <= k)
                                dp[row + 1][col][cost + cCost] = Math.max(dp[row + 1][col][cost + cCost], dp[row][col][cost] + score);
                        }

                        if (col + 1 < n) {
                            int score = grid[row][col + 1];
                            int cCost = score == 0 ? 0 : 1;

                            if (cost + cCost <= k)
                                dp[row][col + 1][cost + cCost] = Math.max(dp[row][col + 1][cost + cCost], dp[row][col][cost] + score);
                        }

                    }

                }
            }

            int ans = Integer.MIN_VALUE;
            for (int i = 0; i <= k; i++) {
                ans = Math.max(ans, dp[m - 1][n - 1][i]);
            }

            return ans == Integer.MIN_VALUE ? -1 : ans;
        }
    }

    // wrong implementation
    class Solution_ {
        private int[][] grid;
        private int k, n, m;
        private final int[] cost = {0, 1, 1};

        private Integer[][][] dp;

        public int maxPathScore(int[][] grid, int k) {

            this.grid = grid;
            this.k = k;
            this.n = grid.length;
            this.m = grid[0].length;

            dp = new Integer[n][m][2];

            int[] res = solve(0, 0);

            return res[1];
        }

        private int[] solve(int i, int j) {
            if (i == n - 1 && j == m - 1) {
                return new int[]{cost[grid[i][j]], grid[i][j]}; // {cost, score}
            }

            if (dp[i][j][0] != null && dp[i][j][1] != null) return new int[]{dp[i][j][0], dp[i][j][1]};

            int currentScore = grid[i][j];
            int currentCost = cost[currentScore];

            int[] chosen = new int[2];
            chosen[0] = -1;
            chosen[1] = -1;

            if (i + 1 < n) {
                int[] right = solve(i + 1, j);
                right[0] += currentCost;
                right[1] += currentScore;

                if (right[0] <= k) {
                    chosen[0] = right[0];
                    chosen[1] = right[1];
                }
            }

            if (j + 1 < m) {
                int[] down = solve(i, j + 1);
                down[0] += currentCost;
                down[1] += currentScore;


                if (down[0] <= k && down[1] > chosen[1]) {
                    chosen[0] = down[0];
                    chosen[1] = down[1];
                }
            }

            dp[i][j][0] = chosen[0];
            dp[i][j][1] = chosen[1];

            return chosen;
        }

    }

}
