public class ProblemNo2257 {
    public static void main(String[] args) {

    }

    class Solution {
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            int[][] grid = new int[m][n];
            int total = (m*n) - walls.length - guards.length;

            for(int[] coordinates: walls) grid[coordinates[0]][coordinates[1]] = 1; // for walls, it is 1
            for(int[] coordinates: guards) grid[coordinates[0]][coordinates[1]] = 2; // for guards, it is 2

            for(int[] coordinates: guards) {
                int x = coordinates[0];
                int y = coordinates[1];

                total -= exploring( m, n, x, y, grid);
            }

            return total;
        }

        private int exploring(int m, int n, int x, int y, int[][] grid){
            int seenBy = 0;
            int[][] directions = { {-1,0}, {0,1}, {1,0}, {0,-1} }; // up, right, down, left

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                while (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                        grid[nx][ny] != 1 && grid[nx][ny] != 2) {
                    if (grid[nx][ny] != 3) {
                        seenBy++;
                        grid[nx][ny] = 3;
                    }
                    nx += dir[0];
                    ny += dir[1];
                }
            }

            return seenBy;
        }

    }

}
