import java.util.*;

public class ProblemNo3331 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3331().new Solution();
        System.out.println(Arrays.toString(a.findSubtreeSizes(new int[]{-1, 0, 4, 0, 1}, "abbba")));

    }

    class Solution {

        private String s;
        private int[] parent;
        private Map<Integer, Set<Integer>> original, modified;

        private int[] result;

        public int[] findSubtreeSizes(int[] parent, String s) {
            final int N = parent.length;

            this.original = new HashMap<>();
            this.modified = new HashMap<>();
            this.parent = parent;
            this.s = s;

            this.result = new int[N];

            for (int i = 1; i < N; i++) {
                original.computeIfAbsent(parent[i], (x) -> new HashSet<>()).add(i);
                modified.computeIfAbsent(parent[i], (x) -> new HashSet<>()).add(i);
            }

            dfsOriginal(0, new HashMap<>());
            dfsModified(0);

            return result;
        }

        private void dfsOriginal(int i, Map<Character, Integer> lastSeen) {
            int currentParent = this.parent[i];
            char currChar = this.s.charAt(i);

            int futureParent = -1;

            if (lastSeen.containsKey(currChar)) {
                futureParent = lastSeen.get(currChar);

                if (futureParent != currentParent) {
                    modified.get(currentParent).remove(i);
                    modified.computeIfAbsent(futureParent, x -> new HashSet<>()).add(i);

                    if (modified.get(currentParent).isEmpty()) modified.remove(currentParent);
                }
            }

            lastSeen.put(currChar, i);
            for (int child : this.original.getOrDefault(i, new HashSet<>())) {
                dfsOriginal(child, lastSeen);
            }

            if (futureParent == -1) lastSeen.remove(currChar);
            else lastSeen.put(currChar, futureParent);
        }

        private int dfsModified(int i) {
            if (!modified.containsKey(i)) {
                this.result[i] = 1;
                return 1;
            }

            this.result[i]++; // For the current one

            for (int child : modified.get(i)) {
                this.result[i] += dfsModified(child);
            }

            return this.result[i];
        }

    }

}
