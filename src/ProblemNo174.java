import java.util.Arrays;

public class ProblemNo174 {
    public static void main(String[] args) {
        Solution a = new ProblemNo174().new Solution();
//        System.out.println(a.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(a.calculateMinimumHP(new int[][]{{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}}));
    }

    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            final int n = dungeon.length, m = dungeon[0].length;

            int[][] dp = new int[n + 1][m + 1];

            for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
            dp[n-1][m] = 1;
            dp[n][m-1] = 1;

            for(int i = n-1; i >= 0; i--) {
                for(int j = m-1; j >= 0; j--) {
                    int way = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                    dp[i][j] = Math.max(way,1);
                }
            }

            return dp[0][0];
        }
    }

}
