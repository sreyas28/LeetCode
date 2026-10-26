public class ProblemNo3619 {
    public static void main(String[] args) {

    }

    class Solution {
        private final static int[][] DIRECTION = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        private int N, M;

        public int countIslands(int[][] grid, int k) {
            this.N = grid.length;
            this.M = grid[0].length;

            boolean[][] visited = new boolean[N][M];

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == 0 || visited[i][j]) continue;
                    else if (finder(i, j, grid, visited) % k == 0) count++;
                }
            }

            return count;

        }

        private long finder(int i, int j, int[][] grid, boolean[][] visited) {
            if (visited[i][j] || grid[i][j] == 0) return 0;

            visited[i][j] = true;

            long curSum = grid[i][j];
            boolean result = true;
            for (int[] direction : DIRECTION) {
                int newI = i + direction[0];
                int newJ = j + direction[1];

                if (sanityCheck(newI, newJ)) curSum += finder(newI, newJ, grid, visited);
            }

            return curSum;
        }

        private boolean sanityCheck(int i, int j) {
            return i < this.N && i >= 0 && j < this.M && j >= 0;
        }
    }

}
