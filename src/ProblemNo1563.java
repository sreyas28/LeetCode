public class ProblemNo1563 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1563().new Solution();
        System.out.println(a.stoneGameV(new int[]{1, 2, 3}));

    }

    class Solution {
        private Integer[][] DP;

        public int stoneGameV(int[] stoneValue) {
            final int N = stoneValue.length;
            this.DP = new Integer[N + 1][N + 1];

            int[] prefixSum = new int[N + 1];
            for (int i = 1; i <= N; i++) prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];

            return dfs(0, N - 1, prefixSum);
        }

        private int dfs(int start, int end, int[] prefixSum) {
            if (end == start) return 0;

            if (DP[start][end] != null) return DP[start][end];

            int max = 0;
            for (int i = start; i <= end; i++) {

                // first part will be start and i
                // second will be i+1 and end right ???

                int sumLeft = prefixSum[i + 1] - prefixSum[start];
                int sumRight = prefixSum[end + 1] - prefixSum[i + 1];

                if (sumLeft > sumRight) max = Math.max(max, dfs(i + 1, end, prefixSum) + sumRight);
                else if (sumLeft < sumRight) max = Math.max(max, dfs(start, i, prefixSum) + sumLeft);
                else {
                    int temp = Math.max(dfs(i + 1, end, prefixSum) + sumRight, dfs(start, i, prefixSum) + sumLeft);
                    max = Math.max(max, temp);
                }
            }

            DP[start][end] = max;
            return max;
        }
    }

}
