import java.util.Arrays;

public class ProblemNo1559 {
    public static void main(String[] args) {

    }

    class Solution {
        private int[][] parentX;
        private int[][] parentY;

        private char[][] grid;

        private boolean[][] visited;
        private int n, m;

        public boolean containsCycle(char[][] grid) {
            n = grid.length;
            m = grid[0].length;

            this.visited = new boolean[n][m];
            this.parentX = new int[n][m];
            this.parentY = new int[n][m];
            this.grid = grid;

            for (int i = 0; i < n; i++) {
                Arrays.fill(parentX[i], -1);
                Arrays.fill(parentY[i], -1);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) continue;
                    if (dfs(i,j, grid[i][j], -1,-1)) return true;
                }
            }

            return false;
        }

        private boolean dfs(int x, int y, int currentChar, int parentX_coordinate, int parentY_coordinate) {
            if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != currentChar) return false;

            if  (visited[x][y]) {
                if (parentX[parentX_coordinate][parentY_coordinate] == x &&
                        parentY[parentX_coordinate][parentY_coordinate] == y) return false;

                else return true;
            }

            visited[x][y] = true;
            parentX[x][y] = parentX_coordinate;
            parentY[x][y] = parentY_coordinate;

            return dfs(x, y + 1, currentChar, x, y) || dfs(x, y - 1, currentChar, x, y) ||
                    dfs(x + 1, y, currentChar, x, y) || dfs(x - 1, y, currentChar, x, y);
        }

    }

}
