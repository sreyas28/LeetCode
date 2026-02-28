public class ProblemNo1680 {
    public static void main(String[] args) {
        ProblemNo1680.Solution p = new ProblemNo1680().new Solution();
        System.out.println(p.concatenatedBinary(12));
    }

    class Solution {
        public int concatenatedBinary(int n) {
            final int MOD = 1_000_000_007;

            long ans = 1;
            int offset = 2;

            for (int i = 2; i <= n; i++) {
                offset = (int) (Math.log(i) / Math.log(2)) + 1;

                ans = ((ans << offset) + i) % MOD;
            }

            return (int) ans % MOD;
        }
    }

}
