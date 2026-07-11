import java.util.*;

public class ProblemNo2685 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2685().new Solution();
        System.out.println(a.countCompleteComponents(6, new int[][] {{0,1},{0,2},{1,2},{3,4}} ));

    }

    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
             ArrayList<Integer>[] graph = new ArrayList[n];

             for (int i = 0; i < n; i++) {
                 graph[i] = new ArrayList<>();
                 graph[i].add(i);
             }

             for(int[] edge : edges) {
                 graph[edge[0]].add(edge[1]);
                 graph[edge[1]].add(edge[0]);
             }

             Map<ArrayList<Integer>, Integer> map = new HashMap<>();

             for(ArrayList<Integer> list : graph) {
                 list.sort(Comparator.naturalOrder());
                 map.put(list, map.getOrDefault(list, 0) + 1);
             }

             int count = 0;
             for(ArrayList<Integer> list : map.keySet()) {
                 if (list.size() == map.get(list)) count++;
             }

            return count;
        }
    }

}
