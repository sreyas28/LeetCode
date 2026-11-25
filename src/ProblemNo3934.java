import java.util.HashMap;
import java.util.Map;

public class ProblemNo3934 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3934().new Solution();
        System.out.println(a.smallestUniqueSubarray(new int[]{1, 1, 2, 2, 1}));

    }

    class Solution {
        private static final long BASE = 100007L;
        private static final long MOD = 1_000_000_007L;

        public int smallestUniqueSubarray(int[] nums) {
            final int N = nums.length;

            long[] powers = new long[N + 1];
            long[] hashes = new long[N + 1];
            powers[0] = 1;

            for (int i = 0; i < N; i++) {
                powers[i + 1] = (powers[i] * BASE) % MOD;
                hashes[i + 1] = (hashes[i] * BASE + nums[i]) % MOD;
            }

            int left = 1, right = N;
            int ans = Integer.MAX_VALUE;

            while (left <= right) {
                int subArrayLen = (right + left) / 2;

                if (helper(subArrayLen, N, powers[subArrayLen], hashes)) {
                    ans = subArrayLen;
                    right = subArrayLen - 1;
                } else left = subArrayLen + 1;
            }

            return ans;
        }

        private boolean helper(int len, int n, long power, long[] hashes) {
            Map<Long, Integer> freq = new HashMap<>();

            for (int left = 0; left <= n - len; left++) {
                int right = left + len;

                long hash = (hashes[right] - ((hashes[left] * power) % MOD) + MOD) % MOD;
                freq.put(hash, freq.getOrDefault(hash, 0) + 1);
            }

            for (int count : freq.values()) {
                if (count == 1) return true;
            }

            return false;
        }
    }

}
