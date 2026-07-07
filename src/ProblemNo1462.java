import java.util.*;

public class ProblemNo1462 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1462().new Solution();
        System.out.println(a.checkIfPrerequisite(3, new int[][]{{1,2},{1,0},{2,0}},new int[][]{}));

    }

    class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            boolean[][] connections = new boolean[numCourses][numCourses];

            for(int i = 0; i < numCourses; i++) connections[i][i] = true;

            for(int[] pre: prerequisites) {
                connections[pre[0]][pre[1]] = true;
            }

            for (int k = 0; k < numCourses; k++) {
                for (int i = 0; i < numCourses; i++) {
                    if (i == k) continue;
                    for (int j = 0; j < numCourses; j++) {
                        if (j == k) continue;

                        boolean reachable = connections[i][k] && connections[k][j];
                        if (reachable) connections[i][j] = true;
                    }
                }
            }

            List<Boolean> ans = new ArrayList<>();
            for(int[] query: queries) {
                if (connections[query[0]][query[1]]) ans.add(true);
                else ans.add(false);
            }

            return ans;
        }
    }

}
