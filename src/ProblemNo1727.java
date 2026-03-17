import java.util.Arrays;
import java.util.Collections;

public class ProblemNo1727 {
    public static void main(String[] args) {

    }

    class Solution {
        public int largestSubmatrix(int[][] matrix) {
            int max = 0, rows = matrix.length, cols = matrix[0].length;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] != 0 && row > 0) {
                        matrix[row][col] += matrix[row - 1][col];
                    }
                }

                int[] current = matrix[row].clone();
                Arrays.sort(current);

                for (int col = 0; col < cols; col++) {
                    max = Math.max(max, current[col] * (cols - col));
                }
            }
            return max;
        }
    }

}
