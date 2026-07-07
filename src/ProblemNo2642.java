import java.util.Arrays;

public class ProblemNo2642 {
    public static void main(String[] args) {
        Graph g = new ProblemNo2642().new Graph(4, new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        g.addEdge(new int[]{1, 3, 4});

    }

    class Graph {
        private int[][] dp;
        private int n;

        public Graph(int n, int[][] edges) {
            this.n = n;
            this.dp = new int[n][n];

            for(int[] d: dp) Arrays.fill(d, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) dp[i][i] = 0;

            for(int[] e: edges) dp[e[0]][e[1]] = e[2];

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (i == k) continue;
                    for (int j = 0; j < n; j++) {
                        if (j == k) continue;

                        int edge1 = dp[i][k], edge2 = dp[k][j];
                        if (edge1 == Integer.MAX_VALUE || edge2 == Integer.MAX_VALUE) continue;

                        int sum = edge1 + edge2 ;
                        if (sum < dp[i][j]) dp[i][j] = sum;
                    }
                }
            }
        }

        public void addEdge(int[] edge) {
            dp[edge[0]][edge[1]] = Math.min(dp[edge[0]][edge[1]], edge[2]);

            for (int i = 0; i < n; i++) {
                if (dp[i][edge[0]] == Integer.MAX_VALUE) continue;
                int halfSum = dp[i][edge[0]] + edge[2];

                for (int j = 0; j < n; j++) {
                    int ed = dp[edge[1]][j];
                    if (ed == Integer.MAX_VALUE) continue;

                    if (halfSum + ed < dp[i][j]) dp[i][j] = halfSum + ed;
                }
            }
        }

        public int shortestPath(int node1, int node2) {
            return dp[node1][node2] ==  Integer.MAX_VALUE ? -1 : dp[node1][node2];
        }
    }

}
