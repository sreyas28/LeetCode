import java.util.List;

public class ProblemNo2596 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2596().new Solution();
        System.out.println(a.checkValidGrid(new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}}));

    }

    class Solution {
        final private int[][] DIR = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        public boolean checkValidGrid(int[][] grid) {
            final int N = grid.length;

            if (grid[0][0] != 0) return false;

            return recursion(0, 0, N, grid);
        }

        private boolean sanityCheck(int row, int col, int N) {
            return row >= 0 && row < N && col >= 0 && col < N;
        }

        private boolean recursion(int row, int col, int N, int[][] grid) {
            if (grid[row][col] == (N * N) - 1) return true;

            int curVal = grid[row][col];

            for (int[] dir : DIR) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (sanityCheck(nextRow, nextCol, N) && grid[nextRow][nextCol] == curVal + 1) {
                    if (recursion(nextRow, nextCol, N, grid)) return true;
                    break;
                }
            }

            return false;
        }
    }

}
