public class ProblemNo1594 {
    public static void main(String[] args) {

        ProblemNo1594.Solution p = new ProblemNo1594().new Solution();
        System.out.println(p.maxProductPath(new int[][]{{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}}));

    }

    class Solution {
        public int maxProductPath(int[][] grid) {
            final int m = grid.length, n = grid[0].length;
            final int MOD = 1_000_000_007;

            long[][] dpMax = new long[m][n];
            long[][] dpMin = new long[m][n];

            dpMax[0][0] = dpMin[0][0] = grid[0][0];

            // for row
            for (int i = 1; i < m; i++) dpMax[i][0] = dpMin[i][0] = dpMin[i-1][0] * grid[i][0];

            // for col
            for (int i = 1; i < n; i++) dpMax[0][i] = dpMin[0][i] = dpMin[0][i-1] * grid[0][i];

            for (int row = 1; row < m; row++) {
                for (int col = 1; col < n; col++) {
                    int val = grid[row][col];

                    long a = dpMax[row - 1][col] * val;
                    long b = dpMax[row][col - 1] * val;
                    long c = dpMin[row - 1][col] * val;
                    long d = dpMin[row][col - 1] * val;

                    dpMax[row][col] = Math.max(Math.max(a, b), Math.max(c, d));
                    dpMin[row][col] = Math.min(Math.min(a, b), Math.min(c, d));
                }
            }

            long result = dpMax[m - 1][n - 1];
            return result >= 0 ? (int) (result % MOD) : -1;
        }
    }

    // brute Force
    class Solution_ {
        private int m, n;
        private int[][] grid;

        private long max = Long.MIN_VALUE;

        public int maxProductPath(int[][] grid) {
            this.grid = grid;
            m = grid.length;
            n = grid[0].length;

            DFS(0, 0, 1);

            int MOD = 1_000_000_007;
            return max >= 0 ? (int) (max % MOD) : -1;
        }

        private void DFS(int i, int j, long product) {
            product = product * grid[i][j];

            if (i == m - 1 && j == n - 1) {
                max = Math.max(max, product);
                return;
            }

            if (i + 1 < m) DFS(i + 1, j, product);
            if (j + 1 < n) DFS(i, j + 1, product);
        }
    }

}
