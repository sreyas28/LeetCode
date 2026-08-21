import java.util.*;

public class ProblemNo51 {
    public static void main(String[] args) {
        Solution solution = new ProblemNo51().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    class Solution {
        private List<List<String>> combinations;

        public List<List<String>> solveNQueens(int n) {
            this.combinations = new ArrayList<>();
            boolean[][] queens = new boolean[n][n];
            backtrack(queens, 0);

            return combinations;
        }

        private void backtrack(boolean[][] queen, int row) {
            if (row == queen.length) {
                combinations.add(construct(queen));
                return;
            }

            for (int i = 0; i < queen[0].length; i++) {
                queen[row][i] = true;
                if (sanityTest(queen, row, i)) backtrack(queen, row + 1);
                queen[row][i] = false;
            }
        }

        private boolean sanityTest(boolean[][] queen, int row, int col) {
            // vertical
            for (int i = 0; i < row; i++) {
                if (queen[i][col]) return false;
            }

            // principle diagonal
            for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
                if (queen[r][c]) return false;
            }

            // another diagonal
            for (int r = row - 1, c = col + 1; r >= 0 && c < queen[0].length ; r--, c++) {
                if (queen[r][c]) return false;
            }

            return true;
        }

        private static List<String> construct(boolean[][] board) {
            List<String> res = new ArrayList<>();
            for (boolean[] row : board) {
                StringBuilder sb = new StringBuilder();
                for (boolean cell : row) {
                    if (cell) sb.append("Q");
                    else sb.append(".");
                }
                res.add(sb.toString());
            }
            return res;
        }

    }

}
