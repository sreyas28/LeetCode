public class ProblemNo3756 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3756().new Solution();
        System.out.println(a.sumAndMultiply("2711785625", new int[][]{{0, 9}}));

    }

    class Solution {
        final private static int MOD = 1_000_000_007;

        public int[] sumAndMultiply(String s, int[][] queries) {
            final int N = s.length();
            int[] prefixSum = new int[N + 1];
            int[] count = new int[N + 1];
            int[] pow10 = new int[N + 1];
            int[] subSet = new int[N + 1];

            pow10[0] = 1;

            for (int i = 0; i < N; i++) {
                int c = s.charAt(i) - '0';

                prefixSum[i + 1] = prefixSum[i] + c;
                count[i + 1] = count[i] + (c == 0 ? 0 : 1);
                subSet[i + 1] = Math.toIntExact(c == 0 ? subSet[i] : ((long) subSet[i] * 10 + c) % MOD);
                pow10[i + 1] = Math.toIntExact(((long) pow10[i] * 10) % MOD);
            }

            final int NQ = queries.length;
            int[] result = new int[NQ];

            for (int i = 0; i < NQ; i++) {
                int l = queries[i][0];
                int r = queries[i][1] + 1;

                int len = count[r] - count[l];
                long val = ((subSet[r] - ((long) subSet[l] * pow10[len]) % MOD) + MOD) % MOD;
                long pre = prefixSum[r] - prefixSum[l];

                result[i] = (int) ((val * pre) % MOD);
            }

            return result;
        }
    }

}
