import java.util.*;

public class ProblemNo207 {
    public static void main(String[] args) {
        ProblemNo207.Solution p = new ProblemNo207().new Solution();
        System.out.println(p.canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
    }

    class Solution {
        private Map<Integer, List<Integer>> adjMat;
        private boolean[] visited;
        private Set<Integer> visitedSet;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            adjMat = new HashMap<>();
            visited = new boolean[numCourses];
            visitedSet = new HashSet<>();

            for (int[] prerequisite : prerequisites) {
                adjMat.computeIfAbsent(prerequisite[1], a -> new ArrayList<>()).add(prerequisite[0]);
            }

            for  (int key: adjMat.keySet()) {
                if (!visited[key]) {
                    boolean[] inRecursion = new boolean[numCourses];
                    inRecursion[key] = true;
                    if (!dfs(key, inRecursion)) return false;
                }
            }

            return true;
        }

        private boolean dfs(int curr, boolean[] inRecursion) {
            if (visitedSet.contains(curr)) return true;

            visited[curr] = true;

            for (int next: adjMat.getOrDefault(curr,  new ArrayList<>())) {
                if (visited[next] && inRecursion[next]) return false; // means loop exists

                inRecursion[next] = true;
                if (!dfs(next, inRecursion)) return false;
                inRecursion[next] = false;
            }

            visitedSet.add(curr);
            return true;
        }
    }
}
