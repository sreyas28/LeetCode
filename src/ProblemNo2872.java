import java.util.*;

public class ProblemNo2872 {
    public static void main(String[] args) {
        ProblemNo2872.Solution a = new ProblemNo2872().new Solution();
        System.out.println(a.maxKDivisibleComponents( 5, new int[][]{{0,2},{1,2},{1,3},{2,4}}, new int[] {1,8,1,4,4}, 6));
    }

    class Solution {

        private Map<Integer, List<Integer>> adj;
        private int[] values;
        private int k;
        private int result;

        public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
            this.adj = new HashMap<>();
            this.values = values;
            this.k = k;

            for(int[] i: edges){
                int l = i[0], r = i[1];

                adj.computeIfAbsent(l, a -> new ArrayList<>()).add(r);
                adj.computeIfAbsent(r, a -> new ArrayList<>()).add(l);
            }

            boolean[] visited = new boolean[n];

            visited[0] = true;

            DFS(0, visited);

            return result;
        }

        private long DFS(int current, boolean[] visited){
            long sum = values[current];

            for(int cons: adj.get(current)){
                if(!visited[cons]){
                    visited[cons] = true;
                    sum += DFS(cons, visited);
                }
            }

            if(sum % k == 0) {
                result++;
                return 0;
            }
            return sum;
        }

    }

}
