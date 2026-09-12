import java.util.Arrays;

public class ProblemNo1751 {
    public static void main(String[] args) {

        ProblemNo1751.Solution a = new ProblemNo1751().new Solution();
//        System.out.println(a.maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2));
        System.out.println(a.maxValue(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}, 3));

    }

    class Solution {
        private int N;
        private Integer[][] memo;

        public int maxValue(int[][] events, int k) {
            this.N = events.length;
            this.memo = new Integer[N][k + 1];

            Arrays.sort(events, (a, b) -> a[0] - b[0]);

            int[] nextGoodIndex = new int[N];
            for (int i = 0; i < N; i++) {
                // Binary Search for nextGoodIndex
                int left = i + 1, right = N - 1, nextIndex = N;
                int rightBound = events[i][1];

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (events[mid][0] > rightBound) {
                        nextIndex = mid;
                        right = mid - 1;
                    } else left = mid + 1;
                }

                nextGoodIndex[i] = nextIndex;
            }

            return dfs(events, k, 0, nextGoodIndex);
        }

        private int dfs(int[][] events, int k, int i, int[] nextGoodIndex) {
            if (i >= N) return 0;

            if (memo[i][k] != null) return memo[i][k];

            // skip it
            int skip = dfs(events, k, i + 1, nextGoodIndex);

            // taking it
            int take = 0;
            if (k > 0) take = events[i][2] + dfs(events, k - 1, nextGoodIndex[i], nextGoodIndex);

            memo[i][k] = Math.max(skip, take);
            return memo[i][k];
        }
    }

}
