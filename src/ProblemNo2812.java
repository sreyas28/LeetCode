import java.util.*;

public class ProblemNo2812 {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}};

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(new ArrayList<>());
            for (int j : arr[i]) {
                list.get(i).add(j);
            }
        }

        Solution a = new ProblemNo2812().new Solution();
        System.out.println(a.maximumSafenessFactor(list));
    }

    class Solution {
        private int N;
        final private int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        private int[][] safetyNess;

        public int maximumSafenessFactor(List<List<Integer>> grid) {
            this.N = grid.size();
            this.safetyNess = new int[N][N];

            int maxDistance = 0;
            Queue<int[]> multiStartBFS = getOnes(grid);

            while (!multiStartBFS.isEmpty()) {
                int size = multiStartBFS.size();

                while (size-- > 0) {
                    int[] cur = multiStartBFS.poll();
                    for (int[] dir : DIR) {
                        int newX = cur[0] + dir[0];
                        int newY = cur[1] + dir[1];
                        int val = safetyNess[cur[0]][cur[1]];

                        if (sanityCheck(newX, newY) && safetyNess[newX][newY] == -1) {
                            safetyNess[newX][newY] = val+1;
                            maxDistance = Math.max(maxDistance, val+1);
                            multiStartBFS.add(new int[] {newX, newY});
                        }
                    }
                }
            }

            if (safetyNess[N - 1][N - 1] == 0 || safetyNess[0][0] == 0) return 0;

            boolean[] safetyCheck = new boolean[maxDistance+1];
            int res = 0;
            int left = 0, right = maxDistance;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if  (isSafe(mid)) {
                    res = mid;
                    left = mid + 1;
                }
                else right = mid -1;

            }

            return res;
        }

        private Queue<int[]> getOnes(List<List<Integer>> grid) {
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid.get(i).get(j) == 1) {
                        this.safetyNess[i][j] = 0;
                        queue.add(new int[]{i, j});
                    } else this.safetyNess[i][j] = -1;
                }
            }

            return queue;
        }

        private boolean sanityCheck(int newX, int newY) {
            return newX >= 0 && newX < N && newY >= 0 && newY < N;
        }

        private boolean isSafe(int safeLimit) {
            if (safetyNess[0][0] < safeLimit || safetyNess[N-1][N-1] < safeLimit) return false;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new  int[]{0, 0});
            boolean[][] visited = new boolean[N][N];
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if  (cur[0] == N-1 && cur[1] == N-1) return true;

                for (int[] dir : DIR) {
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];

                    if (sanityCheck(newX, newY) && !visited[newX][newY] && safetyNess[newX][newY] >= safeLimit) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }

            return false;
        }
    }

}
