public class ProblemNo1292 {
    public static void main(String[] args) {
        ProblemNo1292.Solution p = new ProblemNo1292().new Solution();
        System.out.println(p.maxSideLength(new int[][]{{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}}, 4));
    }

    // bit faster
    class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            int m = mat.length, n = mat[0].length;

            long[][] prefix2dSum = new long[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    prefix2dSum[i][j] = mat[i - 1][j - 1] + prefix2dSum[i - 1][j] + prefix2dSum[i][j - 1] - prefix2dSum[i - 1][j - 1];
                }
            }

            int maxSize = 0;

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    int maxSizeCanAchieve = Math.min(m - row, n - col);

                    for (int size = 0; size <= maxSizeCanAchieve; size++) {
                        int newRow = row + size;
                        int newCol = col + size;

                        long sum = prefix2dSum[newRow][newCol] - prefix2dSum[row][newCol] - prefix2dSum[newRow][col] + prefix2dSum[row][col];

                        if (sum <= threshold) maxSize = Math.max(maxSize, size);
                        else break;
                    }
                }
            }

            return maxSize;

        }
    }

    // working but bit slow but it will not give tle
    class Solution_ {
        public int maxSideLength(int[][] mat, int threshold) {
            int m = mat.length, n = mat[0].length;

            int[][] rowsSum = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) rowsSum[i][j] = mat[i][j];
                    else rowsSum[i][j] = rowsSum[i][j - 1] + mat[i][j];
                }
            }

            int maxSize = 0;

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    int maxSizeCanAchieve = Math.min(m - row - 1, n - col - 1);

                    for (int size = 0; size <= maxSizeCanAchieve; size++) {
                        int newRow = row + size;
                        int newCol = col + size;

                        int sum = 0;
                        for (int count = row; (count <= newRow) && sum <= threshold; count++) {
                            sum += rowsSum[count][newCol] - (col == 0 ? 0 : rowsSum[count][col - 1]);
                        }

                        if (sum <= threshold) maxSize = Math.max(maxSize, size + 1);
                        else break;
                    }
                }
            }

            return maxSize;
        }
    }

}
