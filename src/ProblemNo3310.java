import java.util.*;

public class ProblemNo3310 {
    public static void main(String[] args) {

    }

    class Solution {
        private boolean[] visited;
        private Set<Integer> groupK;

        public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
            visited = new boolean[n + 1];
            groupK = new HashSet<>();
            Map<Integer, List<Integer>> adj = new HashMap<>();


            for (int[] in : invocations) adj.computeIfAbsent(in[0], a -> new ArrayList<>()).add(in[1]);
            DFS(k, adj);

            List<Integer> result = new ArrayList<>();
            boolean flag = false;

            for (int[] in : invocations) {
                if (groupK.contains(in[0])) continue;
                if (groupK.contains(in[1])) {
                    flag = true;
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (flag || !groupK.contains(i)) result.add(i);
            }

            return result;
        }

        private void DFS(int i, Map<Integer, List<Integer>> adj) {
            if (visited[i]) return;

            visited[i] = true;
            groupK.add(i);
            for (int j : adj.getOrDefault(i, new ArrayList<>())) DFS(j, adj);
        }
    }

}
