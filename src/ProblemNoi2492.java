import java.util.*;

public class ProblemNoi2492 {
    public static void main(String[] args) {

    }

    class Solution {
        // roads have [i, j, cost]
        public int minScore(int n, int[][] roads) {
            Map<Integer, List<int[]>> graph = new HashMap<>();

            for (int[] edge : roads) {
                graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
                graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(new  int[]{edge[0], edge[2]});
            }

            boolean[] visited = new boolean[n + 1];
            visited[1] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);

            int minEdge = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int[] edge : graph.get(cur)) {
                    minEdge = Math.min(minEdge, edge[1]);

                    if (visited[edge[0]]) continue;
                    visited[edge[0]] = true;
                    queue.add(edge[0]);
                }
            }

            return minEdge == Integer.MAX_VALUE ? -1 : minEdge;
        }
    }

}
