public class ProblemNo3665 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3665().new Solution();
        System.out.println(a.uniquePaths(new int[][] {{0,1,0},{0,0,1},{1,0,0}}));

    }

    class Solution {

        public int uniquePaths(int[][] grid) {
            final int N = grid.length, M = grid[0].length;
            final int MOD = 1_000_000_007;

            int[][][] gridDP =  new int[N][M][2]; // {FromLeft, FromTop}
            gridDP[0][0][0] = 1;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    boolean mirror = grid[i][j] == 1;

                    if (!mirror) {
                        int sum = (gridDP[i][j][0] + gridDP[i][j][1]) % MOD;

                        if (j + 1 < M) gridDP[i][j+1][0] = (gridDP[i][j+1][0] + sum) % MOD;
                        if (i + 1 < N) gridDP[i+1][j][1] = (gridDP[i+1][j][1] + sum) % MOD;

                        continue;
                    }

                    if (j + 1 < M) gridDP[i][j+1][0] = (gridDP[i][j+1][0] + gridDP[i][j][1]) % MOD;
                    if (i + 1 < N) gridDP[i+1][j][1] = (gridDP[i+1][j][1] + gridDP[i][j][0]) % MOD;
                }
            }

            return (gridDP[N-1][M-1][0] + gridDP[N-1][M-1][1]) % MOD;
        }
    }

}
