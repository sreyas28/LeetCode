import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo200 {
    public static void main(String[] args) {

    }

    class Solution {
        private boolean[][] visited;
        private int N, M;

        public int numIslands(char[][] grid) {
            this.N = grid.length;
            this.M = grid[0].length;

            this.visited = new  boolean[N][M];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if  (!visited[i][j] && grid[i][j] == '1') {
                        BFS(grid, i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        private void BFS(char[][] grid, int i, int j) {
            final int[][] DIR = {{0,1}, {1,0}, {0,-1}, {-1,0}};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {i, j});
            visited[i][j] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int[] dir : DIR) {
                    int nextI = cur[0] + dir[0];
                    int nextJ = cur[1] + dir[1];

                    if (sanityCheck(nextI, nextJ) && !visited[nextI][nextJ] && grid[nextI][nextJ] == '1') {
                        visited[nextI][nextJ] = true;
                        queue.add(new int[] {nextI, nextJ});
                    }
                }
            }
        }

        private boolean sanityCheck(int i, int j) {
            return i >= 0 && i < N && j >= 0 && j < M;
        }

    }

}
