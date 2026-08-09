public class ProblemNo1140 {
    public static void main(String[] args) {
        Solution a = new ProblemNo1140().new Solution();
        System.out.println(a.stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }

    class Solution {
        private Integer[][] DP_ALICE, DP_BOB;

        public int stoneGameII(int[] piles) {
            DP_ALICE = new Integer[piles.length + 1][129];
            DP_BOB = new Integer[piles.length + 1][129];

            int[] prefixSum = new int[piles.length + 1];

            for (int i = 1; i <= piles.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + piles[i - 1];
            }

            return alice(0, 1, prefixSum);
        }

        private int alice(int idx, int m, int[] prefixSum) {
            if  (idx >= prefixSum.length - 1) return 0;

            if (DP_ALICE[idx][m] != null) return DP_ALICE[idx][m];

            int limit = Math.min(2 * m, prefixSum.length - idx - 1);
            int max = 0;
            for (int i = 1; i <= limit; i++) {
                max = Math.max(max, bob(idx + i, Math.max(m, i), prefixSum) + prefixSum[idx + i] - prefixSum[idx]);
            }

            DP_ALICE[idx][m] = max;
            return max;
        }

        private int bob(int idx, int m, int[] prefixSum) {
            if (idx >= prefixSum.length - 1) return 0;

            if (DP_BOB[idx][m] != null) return DP_BOB[idx][m];

            int limit = Math.min(2 * m, prefixSum.length - idx - 1);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= limit; i++) {
                min = Math.min(min, alice(idx + i, Math.max(m, i), prefixSum));
            }

            DP_BOB[idx][m] = min;
            return min;
        }
    }

}
