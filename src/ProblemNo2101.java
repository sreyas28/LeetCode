import java.util.ArrayList;
import java.util.List;

public class ProblemNo2101 {
    public static void main(String[] args) {
        Solution a = new ProblemNo2101().new Solution();
        System.out.println(a.maximumDetonation(new int[][] {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
    }

    class Solution {
        public int maximumDetonation(int[][] bombs) {
            final int N = bombs.length;
            List<List<Integer>> connections = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                connections.add(new ArrayList<>());

                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (check(bombs[i], bombs[j])) connections.getLast().add(j);
                }
            }

            int maxCount = 0;
            for (int i = 0; i < N; i++) {
                maxCount = Math.max(maxCount, connectedBombs(connections, i, new boolean[N]));
            }

            return maxCount;
        }

        private int connectedBombs(List<List<Integer>> connections, int i, boolean[] visited) {
            if (visited[i]) return 0;

            visited[i] = true;
            int count = 1;
            for(int co: connections.get(i)) count += connectedBombs(connections, co, visited);
            return count;
        }

        private boolean check(int[] bomb_1, int[] bomb_2) {
            long dx = bomb_2[0] - bomb_1[0];
            long dy = bomb_2[1] - bomb_1[1];
            return dx * dx + dy * dy <= (long) bomb_1[2] * bomb_1[2];
        }
    }

}
