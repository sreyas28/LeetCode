import java.util.Arrays;

public class ProblemNo3546 {
    public static void main(String[] args) {
        ProblemNo3546.Solution problem = new ProblemNo3546().new Solution();
        System.out.println(problem.canPartitionGrid(new int[][]{{1, 2, 3}, {4, 5, 4}, {3, 2, 1}}));
    }

    class Solution {
        public boolean canPartitionGrid(int[][] grid) {
            final int rows = grid.length, cols = grid[0].length;
            long[] rowsPrefixSum = new long[rows];
            long[] colsPrefixSum = new long[cols];

            long sum = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sum += grid[i][j];
                    rowsPrefixSum[i] += grid[i][j];
                    colsPrefixSum[j] += grid[i][j];
                }
            }

            for (int i = 1; i < rows; i++) {
                rowsPrefixSum[i] += rowsPrefixSum[i - 1];
                if (sum - rowsPrefixSum[i-1] == rowsPrefixSum[i-1]) return true;
            }
            for (int i = 1; i < cols; i++) {
                colsPrefixSum[i] += colsPrefixSum[i - 1];
                if (sum - colsPrefixSum[i-1] == colsPrefixSum[i-1]) return true;
            }

            return false;
        }
    }

}
