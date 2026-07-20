import java.util.*;

public class ProblemNo1260 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1260().new Solution();
        System.out.println(a.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));

    }

    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            final int rows = grid.length, cols = grid[0].length;
            final int total = rows * cols;
            k %= total;


            int[][] shift = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int lineIndex = r*cols + c;
                    int newLineIndex = (lineIndex + k) % total;

                    int newR = newLineIndex / cols;
                    int newC = newLineIndex % cols;

                    shift[newR][newC] = grid[r][c];
                }
            }


            List<List<Integer>> result = new ArrayList<>();

            for (int[] row : shift) {
                List<Integer> list = new ArrayList<>();
                for (int col : row) {
                    list.add(col);
                }
                result.add(list);
            }

            return result;
        }
    }

    // a bit slower
    class Solution_ {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            final int rows = grid.length, cols = grid[0].length;

            k %= (rows * cols);

            for (int times = 0; times < k; times++) {
                int[][] shift = new int[rows][cols];

                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols - 1; c++) {
                        shift[r][c + 1] = grid[r][c];
                    }
                    shift[(r + 1) % rows][0] = grid[r][cols - 1];
                }

                grid = shift;
            }

            List<List<Integer>> result = new ArrayList<>();

            for (int[] row : grid) {
                result.add(new ArrayList<>());
                for (int col : row) {
                    result.getLast().add(col);
                }
            }

            return result;
        }
    }

}
