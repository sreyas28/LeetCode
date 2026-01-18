import java.util.Arrays;

public class ProblemNo1895 {
    public static void main(String[] args) {

        ProblemNo1895.Solution p = new ProblemNo1895().new Solution();
//        System.out.println(p.largestMagicSquare(new int[][]{{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}}));
        System.out.println(p.largestMagicSquare(new int[][]{{3, 3}, {3, 3}}));

    }

    class Solution {
        public int largestMagicSquare(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] horizontalSum = new int[m][n];
            int[][] verticalSum = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) horizontalSum[i][j] = grid[i][j];
                    else horizontalSum[i][j] = horizontalSum[i][j - 1] + grid[i][j];

                    if (i == 0) verticalSum[i][j] = grid[i][j];
                    else verticalSum[i][j] = verticalSum[i - 1][j] + grid[i][j];
                }
            }

            System.out.println(Arrays.deepToString(horizontalSum));
            System.out.println(Arrays.deepToString(verticalSum));

            int maxSize = 1;

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    int maxSizeCanAchieve = Math.min(m - row - 1, n - col - 1);
                    if (maxSize >= maxSizeCanAchieve + 1) continue;

                    int principleDigonal = grid[row][col];
                    for (int size = 1; size <= maxSizeCanAchieve; size++) {
                        int limitRow = row + size;
                        int limitCol = col + size;

                        principleDigonal += grid[limitRow][limitCol];
                        boolean soFarGood = true;

                        // checking all rows
                        for (int newRow = row; (newRow <= limitRow) && soFarGood; newRow++) {
                            int toMinusX = col == 0 ? 0 : horizontalSum[newRow][col - 1];
                            if (horizontalSum[newRow][limitCol] - toMinusX != principleDigonal) soFarGood = false;
                        }

                        // checking all cols
                        for (int newCol = col; (newCol <= limitCol) && soFarGood; newCol++) {
                            int toMinusY = row == 0 ? 0 : verticalSum[row - 1][newCol];
                            if (verticalSum[limitRow][newCol] - toMinusY != principleDigonal) soFarGood = false;
                        }

                        // checking all Digonal
                        int secondaryDigonal = 0;
                        for (int i = row, j = limitCol, iterator = 0; iterator <= size; iterator++, i++, j--)
                            secondaryDigonal += grid[i][j];

                        if (secondaryDigonal != principleDigonal) soFarGood = false;


                        if (soFarGood) {
                            maxSize = Math.max(maxSize, size + 1);
                        }
                    }

                }
            }

            return maxSize;
        }
    }

}
