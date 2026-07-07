import java.util.*;

public class ProblemNo743 {
    public static void main(String[] args) {

    }

    // Dijkstra
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int[] costs = new int[n + 1];
            Arrays.fill(costs, Integer.MAX_VALUE);
            costs[k] = 0;

            Map<Integer, List<int[]>> adj = new HashMap<>();
            for (int[] time : times) adj.computeIfAbsent(time[0], a->new ArrayList<>()).add(new int[]{time[1], time[2]});

            Queue<int[]> qu = new ArrayDeque<>();
            qu.add(new int[]{k, 0});

            while (!qu.isEmpty()) {
                int[] curNode = qu.poll();
                int node = curNode[0];
                int curCost = curNode[1];

                if (curCost > costs[node]) continue;

                for (int[] edge : adj.getOrDefault(node, new ArrayList<>())) {
                    int newCost = curCost + edge[1];

                    if (newCost < costs[edge[0]]) {
                        costs[edge[0]] = newCost;
                        qu.add(new int[]{edge[0], newCost});
                    }
                }
            }


            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, costs[i]);
            }

            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

    // Floyd Warshall
    class Solution_ {
        public int networkDelayTime(int[][] times, int n, int k) {
            int[][] dp = new int[n + 1][n + 1];

            for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
            for (int i = 1; i <= n; i++) dp[i][i] = 0;

            for (int[] time : times) dp[time[0]][time[1]] = time[2];

            for (int p = 1; p <= n; p++) {
                for (int i = 1; i <= n; i++) {
                    if (i == p) continue;
                    for (int j = 1; j <= n; j++) {
                        if (j == p) continue;

                        int edge1 = dp[i][p], edge2 = dp[p][j];
                        if (edge1 == Integer.MAX_VALUE || edge2 == Integer.MAX_VALUE) continue;
                        int sum = edge1 + edge2;

                        if (sum < dp[i][j]) dp[i][j] = sum;
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, dp[k][i]);
            }

            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

}
