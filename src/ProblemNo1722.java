import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProblemNo1722 {
    public static void main(String[] args) {

        ProblemNo1722.Solution p = new ProblemNo1722().new Solution();
        System.out.println(p.minimumHammingDistance(new int[]{5, 1, 2, 4, 3}, new int[]{1, 5, 4, 2, 3}, new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}}));

    }

    class Solution {
        private int[] parent;

        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
            final int n = source.length;

            this.parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;

            Map<Integer, Map<Integer, Integer>> children = new HashMap<>();

            // unions
            for (int[] a : allowedSwaps) union(a[0], a[1]);

            // making children
            for (int i = 0; i < n; i++) {
                children.putIfAbsent(find(i), new HashMap<>());
                Map<Integer, Integer> map = children.get(find(i));

                map.put(source[i], map.getOrDefault(source[i], 0) + 1);
            }

            int distance = 0;
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> curr = children.get(find(i));
                if ( curr.getOrDefault(target[i], 0) > 0) curr.put(target[i], curr.get(target[i]) - 1);
                else distance++;
            }

            return distance;
        }

        private int find(int i) {
            if (parent[i] == i) return i;
            else return find(parent[i]);
        }

        private void union(int i, int j) {
            parent[find(j)] = find(i);
        }

    }

    class Solution__ {
        private int[] parent;

        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
            final int n = source.length;

            this.parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;

            Map<Integer, Set<Integer>> children = new HashMap<>();

            // unions
            for (int[] a : allowedSwaps) union(a[0], a[1]);

            // making children
            for (int i = 0; i < n; i++) children.computeIfAbsent(find(i), a -> new HashSet<>()).add(source[i]);

            int distance = 0;
            for (int i = 0; i < n; i++) {
                if (!children.get(find(i)).contains(target[i])) distance++;
            }

            return distance;
        }

        private int find(int i) {
            if (parent[i] == i) return i;
            else return find(parent[i]);
        }

        private void union(int i, int j) {
            parent[find(j)] = find(i);
        }

    }

}
