import java.util.*;

public class ProblemNo3655 {
    public static void main(String[] args) {

        ProblemNo3655.Solution a = new ProblemNo3655().new Solution();
//        System.out.println(a.xorAfterQueries(new int[]{329,112,80}, new int[][] {{2,2,2,20},{0,2,1,19},{0,2,3,9},{1,2,1,11},{2,2,1,11},{0,2,2,11},{1,1,2,2},{0,1,1,14},{1,2,3,8},{2,2,1,14},{2,2,3,10},{2,2,3,1},{1,1,2,12},{0,2,1,15},{0,2,1,3},{1,1,3,15},{1,1,2,2}}));
        System.out.println(a.xorAfterQueries(new int[]{1, 1, 1}, new int[][]{{0, 2, 1, 4}, {0, 2, 1, 4}, {0, 1, 1, 4}}));

    }

    class Solution {
        private final int MOD = 1_000_000_007;

        public int xorAfterQueries(int[] nums, int[][] queries) {
            int n = nums.length;
            int B = (int) Math.sqrt(n);

            List<List<int[]>> bucketsOfK = new ArrayList<>(B);
            for (int i = 0; i < B; i++) bucketsOfK.add(new ArrayList<>());

            for (int[] query : queries) {
                int l = query[0], r = query[1], k = query[2], v = query[3];

                if (k >= B) {
                    for (int i = l; i <= r; i += k) nums[i] = (int) (((long) nums[i] * v) % MOD);
                }
                else bucketsOfK.get(k).add(new int[]{l, r, v});
            }

            long[] diff = new long[n + B];
            for (int k = 1; k < B; k++) {
                if (bucketsOfK.get(k).isEmpty()) continue;

                Arrays.fill(diff, 1L);
                for (int[] q : bucketsOfK.get(k)) {
                    int l = q[0], r = q[1], v = q[2];
                    diff[l] = (diff[l] * v) % MOD;

                    int R = ((r - l) / k + 1) * k + l;
                    diff[R] = (diff[R] * power(v, MOD-2)) % MOD;
                }

                for (int i = k; i < n; i++) diff[i] = (diff[i] * diff[i - k]) % MOD;
                for (int i = 0; i < n; i++) nums[i] = (int) (((long) nums[i] * diff[i]) % MOD);
            }


            int xored = 0;
            for (int i : nums) xored ^= i;

            return xored;
        }

        private int power(long x, long y) {
            long res = 1;

            while (y > 0) {
                if ((y & 1) == 1) res = (res * x) % MOD;
                x = (x * x) % MOD;
                y >>= 1;
            }

            return (int) res;
        }

    }

}
