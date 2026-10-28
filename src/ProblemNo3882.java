import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo3882 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3882().new Solution();
        System.out.println(a.minCost(new int[][]{{1, 2}, {3, 4}}));

    }

    class Solution {
        public int minCost(int[][] grid) {
            final int N = grid.length, M = grid[0].length;

            boolean[][][] dp = new boolean[N][M][1024];
            dp[0][0][grid[0][0]] = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == 0 && j == 0) continue;
                    int val = grid[i][j];

                    for (int k = 0; k < 1024; k++) {
                        if ((i > 0 && dp[i - 1][j][k]) || (j > 0 && dp[i][j - 1][k]))
                            dp[i][j][k ^ val] = true;
                    }
                }
            }

            for(int i = 0; i < 1024; i++) {
                if(dp[N - 1][M - 1][i]) return i;
            }

            return -1;
        }
    }

    // Take 2^N time
    class Solution_ {
        private final static int[][] DIRECTIONS = {{-1, 0}, {0, -1}};
        private int N, M;

        public int minCost(int[][] grid) {
            this.N = grid.length;
            this.M = grid[0].length;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{N - 1, M - 1, 0});

            int min = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int value = grid[cur[0]][cur[1]];

                if (cur[0] == 0 && cur[1] == 0) {
                    min = Math.min(min, cur[2] ^ value);
                    continue;
                }

                for (int[] direction : DIRECTIONS) {
                    int nextX = cur[0] + direction[0];
                    int nextY = cur[1] + direction[1];

                    if (sanityCheck(nextX, nextY)) queue.offer(new int[]{nextX, nextY, cur[2] ^ value});
                }
            }

            return min;
        }

        private boolean sanityCheck(int i, int j) {
            return i >= 0 && i < N && j >= 0 && j < M;
        }
    }
}
