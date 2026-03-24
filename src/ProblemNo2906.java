import java.util.Arrays;

public class ProblemNo2906 {
    public static void main(String[] args) {

        ProblemNo2906.Solution p = new ProblemNo2906().new Solution();
        System.out.println(Arrays.deepToString(p.constructProductMatrix(new int[][]{{1, 2, 3}, {4, 5, 4}, {3, 2, 1}})));

    }

    class Solution {
        public int[][] constructProductMatrix(int[][] grid) {
            final int rows = grid.length, cols = grid[0].length, MOD = 12345;
            int[][] result = new int[rows][cols];

            long suffix = 1;
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    result[i][j] = (int) suffix;
                    suffix = (suffix * grid[i][j]) % MOD;
                }
            }

            long prefix = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = (int) ((result[i][j] * prefix) % MOD);
                    prefix = (prefix * grid[i][j]) % MOD;
                }
            }

            return result;
        }
    }

    // problematic
    class Solution_ {
        public int[][] constructProductMatrix(int[][] grid) {
            int totalProduct = 1;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    totalProduct = (totalProduct * grid[i][j]) % 12345;
                }
            }

            int[][] result = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    result[i][j] = (((totalProduct / grid[i][j]) + 12345) % 12345);
                }
            }

            return result;
        }
    }

}
