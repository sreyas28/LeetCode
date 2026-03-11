public class ProblemNo3130 {
    public static void main(String[] args) {

    }

    class Solution {

        static final int MOD = 1000000007;
        Integer[][][] memo;
        int limit;

        public int numberOfStableArrays(int zero, int one, int limit) {
            this.memo = new Integer[zero + 1][one + 1][2];

            this.limit = limit;
            return (dp(zero, one, 0) + dp(zero, one, 1)) % MOD;
        }

        public int dp(int zero, int one, int lastBit) {
            if (zero == 0) {
                return (lastBit == 0 || one > limit) ? 0 : 1;
            } else if (one == 0) {
                return (lastBit == 1 || zero > limit) ? 0 : 1;
            }

            if (memo[zero][one][lastBit] == null) {
                int res = 0;
                if (lastBit == 0) {
                    res = (dp(zero - 1, one, 0) + dp(zero - 1, one, 1)) % MOD;
                    if (zero > limit) {
                        res = (res - dp(zero - limit - 1, one, 1) + MOD) % MOD;
                    }
                } else {
                    res = (dp(zero, one - 1, 0) + dp(zero, one - 1, 1)) % MOD;
                    if (one > limit) {
                        res = (res - dp(zero, one - limit - 1, 0) + MOD) % MOD;
                    }
                }
                memo[zero][one][lastBit] = res % MOD;
            }
            return memo[zero][one][lastBit];
        }
    }

}
