public class ProblemNo233 {
    public static void main(String[] args) {

        Solution a = new ProblemNo233().new Solution();
        System.out.println(a.countDigitOne(15));

    }

    class Solution {
        public int countDigitOne(int n) {
            Integer[][][] memo = new Integer[String.valueOf(n).length() + 1][2][String.valueOf(n).length()];

            return dfs(0, true, String.valueOf(n), 0, memo);
        }

        private int dfs(int idx, boolean tight, String limit, int countOne, Integer[][][] memo) {
            if (idx == limit.length()) return countOne;
            int l = tight ? limit.charAt(idx) - '0' : 9;

            if (memo[idx][tight ? 0 : 1][countOne] != null) return memo[idx][tight ? 0 : 1][countOne];

            int count = 0;
            for (int i = 0; i <= l; i++) {
                if (tight && i == l) count += dfs(idx+1, true, limit, i == 1 ? countOne + 1 : countOne, memo);
                else count += dfs(idx + 1, false, limit,  i == 1 ? countOne + 1 : countOne, memo);
            }

            memo[idx][tight ? 0 : 1][countOne] = count;
            return count;
        }

    }

}
