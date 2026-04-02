public class ProblemNo3418 {
    public static void main(String[] args) {

        ProblemNo3418.Solution a = new ProblemNo3418().new Solution();
//        System.out.println(a.maximumAmount(new int[][]{{0, 1, -1}, {1, -2, 3}, {2, -3, 4}}));
//        System.out.println(a.maximumAmount(new int[][]{{-4}}));
        System.out.println(a.maximumAmount(new int[][]{{-7, 12, 12, 13}, {-6, 19, 19, -6}, {9, -2, -10, 16}, {-4, 14, -10, -9}}));

    }


    class Solution {
        private int[][] grid;
        private int rows, cols;
        private Integer[][][] DP;


        public int maximumAmount(int[][] coins) {
            this.grid = coins;
            this.rows = coins.length;
            this.cols = coins[0].length;

            DP = new Integer[rows + 1][cols + 1][3];

            return dfs(0, 0, 2);
        }

        private int dfs(int i, int j, int neutralize) {
            if (i == rows - 1 && j == cols - 1) {
                if (neutralize == 0) return grid[i][j];
                return Math.max(grid[i][j], 0);
            }

            if (DP[i][j][neutralize] != null) return DP[i][j][neutralize];

            int currentSum = Integer.MIN_VALUE;
            if (i < rows - 1) {
                currentSum = Math.max(currentSum, dfs(i + 1, j, neutralize) + grid[i][j]);
                if (neutralize > 0)
                    currentSum = Math.max(currentSum, dfs(i + 1, j, neutralize - 1));
            }
            if (j < cols - 1) {
                currentSum = Math.max(currentSum, dfs(i, j + 1, neutralize) + grid[i][j]);
                if (neutralize > 0)
                    currentSum = Math.max(currentSum, dfs(i, j + 1, neutralize - 1));
            }

            DP[i][j][neutralize] = currentSum;

            return currentSum;
        }

    }

}
