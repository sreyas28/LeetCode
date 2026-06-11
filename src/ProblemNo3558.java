import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProblemNo3558 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3558().new Solution();
        System.out.println(a.assignEdgeWeights(new int[][]{{1,2}}));
        System.out.println(a.assignEdgeWeights(new int[][]{{1,2},{1,3},{3,4},{3,5}}));

    }

    class Solution {
        private HashMap<Integer, List<Integer>> Adj;
        private int maxDepth;

        public int assignEdgeWeights(int[][] edges) {
            this.Adj = new HashMap<>();

            for (int[] edge : edges) {
                Adj.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
                Adj.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(edge[0]);
            }

            boolean[] visited = new boolean[Adj.size()+1];
            Arrays.fill(visited, false);
            visited[1] = true;

            DFS(1, visited, 0);

            return (int) power(2, maxDepth - 1);
        }

        private void DFS(int node, boolean[] visited, int depth){
            if (Adj.get(node).size() == 1 && visited[Adj.get(node).getFirst()]) {
                maxDepth = Math.max(maxDepth, depth);
                return;
            }

            for (int i : Adj.get(node)) {
                if (visited[i]) continue;
                visited[i] = true;
                DFS(i, visited, depth + 1);
                visited[i] = false;
            }
        }

        private long power(int n, int k){
            if (k == 0) return 1;

            if (k % 2 == 0) {
                long a = power(n, k / 2) % 1_000_000_007;
                return (a*a) % 1_000_000_007;
            }

            return n * power(n, k - 1) % 1_000_000_007;
        }
    }

}
