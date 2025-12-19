public class ProblemNo3573 {

    public static void main(String[] args) {

    }

    class Solution {

        private int[] prices;
        private long[][][] memo;

        public long maximumProfit(int[] prices, int k) {
            this.prices = prices;
            int n = prices.length;
            memo = new long[n][k + 1][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= k; j++) {
                    for (int s = 0; s < 3; s++) {
                        memo[i][j][s] = -1;
                    }
                }
            }
            return dfs(n - 1, k, 0);
        }

        private long dfs(int i, int j, int state) {
            if (j == 0) {
                return 0;
            }
            if (i == 0) {
                return state == 0 ? 0 : (state == 1 ? -prices[0] : prices[0]);
            }
            if (memo[i][j][state] != -1) {
                return memo[i][j][state];
            }

            int p = prices[i];
            long res;
            if (state == 0) {
                res = Math.max(
                        dfs(i - 1, j, 0),
                        Math.max(dfs(i - 1, j, 1) + p, dfs(i - 1, j, 2) - p)
                );
            } else if (state == 1) {
                res = Math.max(dfs(i - 1, j, 1), dfs(i - 1, j - 1, 0) - p);
            } else {
                res = Math.max(dfs(i - 1, j, 2), dfs(i - 1, j - 1, 0) + p);
            }
            memo[i][j][state] = res;
            return res;
        }
    }

    class Solution_ {

        private int[] prices;

        public long maximumProfit(int[] prices, int k) {
            this.prices = prices;

            // Cases are 0 == Buy or Short sell
            // 1 == sell only
            // 2 == buy only
            // and in all cases a case is there call skip
            return DFS(0, 0, k);
        }

        private long DFS(int index, int CASE, int process){
            if(process <= 0 || index >= prices.length) {
                if (CASE == 0) return 0;
                else return Integer.MIN_VALUE;
            }

            // skip
            long notTake = DFS(index+1, CASE, process);
            long take;

            // Checking Case
            if(CASE == 1){
                // selling
                take = prices[index] + DFS(index+1, 0, process-1);
            }
            else if(CASE == 2){
                // buying
                take = DFS(index+1, 0, process-1) - prices[index];
            }
            else {
                // 0 == Buy or Short sell
                take = Math.max(  DFS(index+1, 1, process) - prices[index], DFS(index+1, 2, process) + prices[index]);
            }

            return Math.max(take, notTake);
        }
    }

}
