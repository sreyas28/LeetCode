import java.util.Arrays;

public class ProblemNo2435 {
    public static void main(String[] args) {

        ProblemNo2435.Solution a = new ProblemNo2435().new Solution();
        System.out.println(a.numberOfPaths(new int[][]{{5,2,4},{3,0,5},{0,7,2}}, 3));

    }

    class Solution {

        private final int MOD = (int) (1e9 + 7);
        private int[][] grid;
        private int k,m,n;
        private Integer[][][] DP;

        public int numberOfPaths(int[][] grid, int k) {
            this.grid = grid;
            this.k = k;
            this.m = grid.length;
            this.n = grid[0].length;

            DP = new Integer[m][n][k];

            return DFS(0,0,0);
        }

        private int DFS(int i, int j, int modSum){
            modSum = (modSum + grid[i][j]) % k;

            if(i == m-1 && j == n-1) return modSum == 0 ? 1: 0;
            if(DP[i][j][modSum] != null) return DP[i][j][modSum];

            int ways = 0;
            if(i+1 < m) ways += DFS(i+1,j,modSum) % MOD;
            if(j+1 < n) ways += DFS(i,j+1,modSum) % MOD;

            DP[i][j][modSum] = ways % MOD;
            return DP[i][j][modSum];
        }
    }

}
