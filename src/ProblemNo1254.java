public class ProblemNo1254 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1254().new Solution();
        System.out.println(a.closedIsland(new int[][]{{0,0,1,0,0},{0,1,0,1,0},{1,0,0,1,0},{0,0,0,0,0}}));

    }

    class Solution {
        private final static int[][] DIRECTION = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        private int N, M;

        public int closedIsland(int[][] grid) {
            this.N = grid.length;
            this.M = grid[0].length;

            boolean[][] visited = new boolean[N][M];

            removeUseless(grid, visited);

            int count = 0;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (grid[i][j] == 1 || visited[i][j]) continue;

                    finder(i, j, grid, visited);
                    count++;
                }
            }

            return count;
        }

        private void removeUseless(int[][] grid, boolean[][] visited) {

            // first row and last row
            for (int k = 0; k < M; k++) {
                if (grid[0][k] == 0 && !visited[0][k]) finder(0, k, grid, visited);
                if (grid[N-1][k] == 0 && !visited[N-1][k]) finder(N-1, k, grid, visited);
            }

            // first col and last col
            for (int k = 0; k < N; k++) {
                if (grid[k][0] == 0 && !visited[k][0]) finder(k, 0, grid, visited);
                if (grid[k][M-1] == 0 && !visited[k][M-1]) finder(k, M-1, grid, visited);
            }
        }

        private void finder(int i, int j, int[][] grid, boolean[][] visited) {
            if (visited[i][j] || grid[i][j] == 1) return;

            visited[i][j] = true;

            boolean result = true;
            for (int[] direction : DIRECTION) {
                int newI = i + direction[0];
                int newJ = j + direction[1];

                if (sanityCheck(newI, newJ)) finder(newI, newJ, grid, visited);
            }
        }

        private boolean sanityCheck(int i, int j) {
            return i < this.N && i >= 0 && j < this.M && j >= 0;
        }


    }

}
