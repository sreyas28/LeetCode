public class ProblemNo3070 {
    public static void main(String[] args) {

    }

    class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int count = 0;
            int rows = grid.length,  cols = grid[0].length;

            if (grid[0][0] <= k) count++;
            else return 0;

            for(int r = 1; r < rows; r++) {
                grid[r][0] +=  grid[r-1][0];
                if(grid[r][0] <= k) count++;
            }
            for(int c = 1; c < cols; c++) {
                grid[0][c] +=  grid[0][c-1];
                if(grid[0][c] <= k) count++;
            }

            for(int r = 1; r < rows; r++) {
                for(int c = 1; c < cols; c++) {
                    grid[r][c] += grid[r-1][c] + grid[r][c-1] - grid[r-1][c-1];
                    if(grid[r][c] <= k) count++;
                }
            }
            return count;
        }
    }

}
