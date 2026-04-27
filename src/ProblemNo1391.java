import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class ProblemNo1391 {
    public static void main(String[] args) {
        ProblemNo1391.Solution a = new ProblemNo1391().new Solution();
        System.out.println(a.hasValidPath(new int[][] {{2,4,3},{6,5,2}}));
    }

    class Solution {
        private Map<Character, int[]> dir;
        private int[][] grid;
        private int n, m;

        public boolean hasValidPath(int[][] grid) {
            if (grid[0][0] == 5) return false;

            dir = new HashMap<>();
            this.grid = grid;
            this.n = grid.length;
            this.m = grid[0].length;

            dir.put('N', new int[]{-1,0});
            dir.put('E', new int[]{0,1});
            dir.put('W', new int[]{0,-1});
            dir.put('S', new int[]{1,0});

            return switch (grid[0][0]) {
                case 1, 3 -> dfs('E', 0, 0, new boolean[n][m]);
                case 2, 6 -> dfs('S', 0, 0, new  boolean[n][m]);
                case 4 -> dfs('N', 0, 0 , new boolean[n][m]) || dfs('W', 0, 0, new boolean[n][m]);
                default -> false;
            };
        }

        private boolean dfs(char direction, int i, int j, boolean[][] visited) {
            if (i == n - 1 && j == m - 1) {
                return switch (direction) {
                    case 'S' -> grid[i][j] == 2 || grid[i][j] == 5 || grid[i][j] == 6;
                    case 'E' -> grid[i][j] == 1 || grid[i][j] == 3 || grid[i][j] == 5;
                    default -> false;
                };
            }

            if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j]) return false;

            int current = grid[i][j];
            visited[i][j] = true;

            switch (current) {
                case 1:
                    if (direction == 'E') return helper(direction, i, j, visited);
                    else if (direction == 'W') return helper(direction, i, j, visited);
                    else return false;
                case 2:
                    if (direction == 'S') return helper(direction, i, j, visited);
                    else if (direction == 'N') return helper(direction, i, j, visited);
                    else return false;
                case 3:
                    if (direction == 'E') return helper('S', i, j, visited);
                    else if (direction == 'N') return helper('W', i, j, visited);
                    else return false;
                case 4:
                    if (direction == 'N') return helper('E', i, j, visited);
                    else if (direction == 'W') return helper('S', i, j, visited);
                    else return false;
                case 5:
                    if (direction == 'E') return helper('N', i, j, visited);
                    else if (direction == 'S') return helper('W', i, j, visited);
                    else return false;
                case 6:
                    if (direction == 'S') return helper('E', i, j, visited);
                    else if (direction == 'W') return helper('N', i, j, visited);
                    else return false;
            }
            return false;
        }

        private boolean helper(char direction, int i, int j, boolean[][] visited) {
            return dfs(direction, i + dir.get(direction)[0], j + dir.get(direction)[1], visited);
        }

    }

}
