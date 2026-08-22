public class ProblemNo79 {

    public static void main(String[] args) {

        Solution a = new ProblemNo79().new Solution();
//        System.out.println(a.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(a.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCEFSADEESE"));

    }

    class Solution {
        private final static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        private int ROW,COL;

        public boolean exist(char[][] board, String word) {
            this.ROW = board.length;
            this.COL = board[0].length;

            for (int i = 0; i < this.ROW; i++) {
                for (int j = 0; j < this.COL; j++) {
                    if (board[i][j] == word.charAt(0) && finder(new boolean[ROW][COL], board, i, j, word, 0)) return true;
                }
            }

            return false;
        }

        private boolean finder(boolean[][] visited, char[][] board, int r, int c, String word, int idx) {
            if (board[r][c] == word.charAt(idx)) {
                visited[r][c] = true;

                if (idx + 1 == word.length()) return true;
                for (int[] dir: DIRECTIONS) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    if (sanityTest(nextR, nextC) && !visited[nextR][nextC] && finder(visited, board, nextR, nextC, word, idx+1)) return true;
                }

                visited[r][c] = false;
            }

            return false;
        }

        private boolean sanityTest(int newR, int newC){
            return newR >= 0 && newC >= 0 && newR < ROW && newC < COL;
        }
    }

}
