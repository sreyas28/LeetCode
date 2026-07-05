import java.util.*;

public class ProblemNo1301 {
    public static void main(String[] args) {
        String[] g = {"E23", "2X2", "12S"};
        List<String> list = new ArrayList<>();

        for (String s : g) {
            list.add(s);
        }

        Solution a = new ProblemNo1301().new Solution();
        System.out.println(Arrays.toString(a.pathsWithMaxScore(list)));

    }

    class Solution {
        final private static int MOD = 1_000_000_007;

        public int[] pathsWithMaxScore(List<String> board) {
            final int ROWS = board.size(), COLS = board.getFirst().length();
            final int[][] DIR = {{0, 1}, {1, 1}, {1, 0}};

            long[][] best = new long[ROWS][COLS];
            long[][] ways = new long[ROWS][COLS];

            for (long[] b : best) Arrays.fill(b, -1);

            best[ROWS - 1][COLS - 1] = 0;
            ways[ROWS - 1][COLS - 1] = 1;

            for (int i = ROWS - 1; i >= 0; i--) {
                for (int j = COLS - 1; j >= 0; j--) {
                    if (i == ROWS - 1 && j == COLS - 1) continue;

                    char c = board.get(i).charAt(j);
                    if (c == 'X') continue;

                    long bestNext = -1, wayCount = 0;
                    for (int[] dir : DIR) {
                        int oldRow = i + dir[0], oldCol = j + dir[1];

                        if (!sanityCheck(oldRow, oldCol, ROWS, COLS)) continue;
                        if (best[oldRow][oldCol] == -1) continue;

                        if (bestNext < best[oldRow][oldCol]) {
                            bestNext = best[oldRow][oldCol];
                            wayCount = ways[oldRow][oldCol];
                        } else if (bestNext == best[oldRow][oldCol]) {
                            wayCount = (ways[oldRow][oldCol] + wayCount) % MOD;
                        }
                    }

                    if (bestNext == -1) continue;

                    int temp = c == 'E' ? 0 : c - '0';
                    best[i][j] = Math.toIntExact(bestNext + temp);
                    ways[i][j] = Math.toIntExact(wayCount);
                }
            }

            if (best[0][0] == -1) return new int[]{0, 0};
            return new int[]{(int) (best[0][0] % MOD), (int) ways[0][0]};
        }

        private boolean sanityCheck(int row, int col, int ROWS, int COLS) {
            return row >= 0 && row < ROWS && col >= 0 && col < COLS;
        }
    }


    // TLE
    class Solution_ {

        public int[] pathsWithMaxScore(List<String> board) {
            final int ROWS = board.size(), COLS = board.get(0).length();
            final int MOD = 1_000_000_007;
            final int[][] DIR = {{0, 1}, {1, 1}, {1, 0}};

            int[][] grid = new int[ROWS][COLS];

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (board.get(i).charAt(j) == 'S' || board.get(i).charAt(j) == 'E') grid[i][j] = 0;
                    else if (board.get(i).charAt(j) == 'X') grid[i][j] = -1;
                    else grid[i][j] = board.get(i).charAt(j) - '0';
                }
            }

            Queue<long[]> queue = new LinkedList<>(); // {row, col, sum}
            queue.offer(new long[]{0, 0, 0});

            TreeMap<Integer, Integer> maxScore = new TreeMap<>();
            while (!queue.isEmpty()) {
                long[] cur = queue.poll();
                int x = (int) cur[0], y = (int) cur[1];
                long score = cur[2] % MOD;

                if (x == ROWS - 1 && y == COLS - 1) {
                    maxScore.put((int) score, maxScore.getOrDefault((int) score, 0) + 1);
                    continue;
                }

                for (int[] dir : DIR) {
                    int nextX = x + dir[0], nextY = y + dir[1];
                    if (!sanityCheck(nextX, nextY, ROWS, COLS)) continue;
                    if (grid[nextX][nextY] == -1) continue;

                    queue.offer(new long[]{nextX, nextY, score + grid[nextX][nextY]});
                }
            }

            if (maxScore.isEmpty()) return new int[]{0, 0};
            return new int[]{maxScore.lastKey(), maxScore.get(maxScore.lastKey())};
        }

        private boolean sanityCheck(int row, int col, int rows, int cols) {
            return (row >= 0 && row < rows && col >= 0 && col < cols);
        }
    }

}
