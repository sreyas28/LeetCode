public class ProblemNo3129 {
    public static void main(String[] args) {

    }

    class Solution {
        private final int MOD = 1_000_000_007;
        private Long DP[][][];

        public int numberOfStableArrays(int zero, int one, int limit) {
            DP = new Long[zero + 1][one + 1][2];

            return (int) ((recursion(zero, one, limit, true) + recursion(zero, one, limit, false)) % MOD);
        }

        private long recursion(int zeroesLeft, int onesLeft, int limit, boolean lastZeroes) {
            if (zeroesLeft == 0 && onesLeft == 0) return 1;

            long ans = 0;
            byte last = (byte) (lastZeroes ? 0 : 1);
            if (DP[zeroesLeft][onesLeft][last] != null) return DP[zeroesLeft][onesLeft][last];

            if (lastZeroes) {
                int minOnesCanAdd = Math.min(limit, onesLeft);
                for (int i = 1; i <= minOnesCanAdd; i++) {
                    ans = (ans + recursion(zeroesLeft, onesLeft - i, limit, false)) % MOD;
                }
            } else {
                int minZeroCanAdd = Math.min(limit, zeroesLeft);
                for (int i = 1; i <= minZeroCanAdd; i++) {
                    ans = (ans + recursion(zeroesLeft - i, onesLeft, limit, true)) % MOD;
                }
            }

            return DP[zeroesLeft][onesLeft][last] = ans;
        }
    }

    // brute Force TLE 😓
    class Solution_ {
        private final int MOD = 1_000_000_007;
        private long count;

        public int numberOfStableArrays(int zero, int one, int limit) {
            count = 0;

            recursion(0, 0, zero, one, limit, true);
            recursion(0, 0, zero, one, limit, false);

            return (int) (count % MOD);
        }

        private void recursion(int currZeroCount, int currOnesCount, int maxOnes, int maxZeroes, int limit, boolean lastZeroes) {
            if (currZeroCount == maxZeroes && currOnesCount == maxOnes) {
                count = (count + 1) % MOD;
            }

            if (lastZeroes) {
                int minOnesCanAdd = Math.min(limit, maxOnes - currOnesCount);
                for (int i = 1; i <= minOnesCanAdd; i++) {
                    recursion(currZeroCount, currOnesCount + i, maxOnes, maxZeroes, limit, false);
                }
            } else {
                int minZeroCanAdd = Math.min(limit, maxZeroes - currZeroCount);
                for (int i = 1; i <= minZeroCanAdd; i++) {
                    recursion(currZeroCount + i, currOnesCount, maxOnes, maxZeroes, limit, true);
                }
            }
        }

    }

}
