public class ProblemNo3693 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3693().new Solution();
        System.out.println(a.climbStairs(4, new int[]{1, 2, 3, 4}));
    }

    class Solution {
        private final static int[] DIFF_COST = {0, 1, 4, 9};

        public int climbStairs(int n, int[] costs) {

            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                int cost = Integer.MAX_VALUE;

                int j = 1;
                while (j <= 3 && i - j >= 0) {
                    cost = Math.min(DIFF_COST[j] + costs[i - 1] + dp[i - j], cost);
                    j++;
                }

                dp[i] = cost;
            }

            return dp[n];
        }
    }

}
