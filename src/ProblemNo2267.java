import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo2267 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2267().new Solution();
        System.out.println(a.hasValidPath(new char[][]{{'(', '(', '('}, {')', '(', ')'}, {'(', '(', ')'}, {'(', '(', ')'}}));
        System.out.println(a.hasValidPath(new char[][]{{'(', ')', ')'}, {'(', '(', ')'}}));

    }

    class Solution {

        static class Node {
            int i;
            int j;
            int balance;

            public Node(int i, int j, int balance) {
                this.i = i;
                this.j = j;
                this.balance = balance;
            }
        }

        public boolean hasValidPath(char[][] grid) {
            final int n = grid.length;
            final int m = grid[0].length;
            final int[][] directions = new int[][]{{1, 0}, {0, 1}};

            boolean[][][] visited = new boolean[n][m][n+m];

            if (grid[0][0] != '(' || grid[n - 1][m - 1] != ')' || (n + m - 1) % 2 != 0) return false;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(0, 0, 0));

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                cur.balance += grid[cur.i][cur.j] == '(' ? 1 : -1;

                if (cur.balance < 0) continue;
                else if (cur.i == n - 1 && cur.j == m - 1) {
                    if (cur.balance == 0) return true;
                    visited[cur.i][cur.j][cur.balance] = true;
                    continue;
                }

                if (visited[cur.i][cur.j][cur.balance]) continue;
                visited[cur.i][cur.j][cur.balance] = true;

                for (int[] dir : directions) {
                    int nextI = cur.i + dir[0];
                    int nextJ = cur.j + dir[1];
                    if (sanityCheck(nextI, nextJ, n, m)) queue.offer(new Node(nextI, nextJ, cur.balance));
                }
            }

            return false;
        }

        private boolean sanityCheck(int i, int j, int n, int m) {
            return (i >= 0 && i < n && j >= 0 && j < m);
        }
    }

}
