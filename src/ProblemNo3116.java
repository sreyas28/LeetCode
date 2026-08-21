import java.util.*;

public class ProblemNo3116 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3116().new Solution();
        System.out.println(a.findKthSmallest(new int[]{3, 6, 9}, 3));
        System.out.println(a.findKthSmallest(new int[]{2, 3}, 7));
        System.out.println(a.findKthSmallest(new int[]{2, 5}, 7));

    }

    class Solution {
        public long findKthSmallest(int[] coins, int k) {
            Arrays.sort(coins);
            List<Integer> newCoins = new ArrayList<>();

            for (int i : coins) {
                boolean flag = true;
                for (int j : newCoins) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) newCoins.add(i);
            }
            coins = newCoins.stream().mapToInt(i -> i).toArray();

            final int n = coins.length;
            final int m = 1 << n;

            long[] lcm = new long[m];
            for (int mask = 1; mask < m; mask++) {
                long localLCM = 1;
                for (int i = 0; i < n; i++) {
                    if ((mask >> i & 1) == 1) localLCM = localLCM * (coins[i] / GCD(coins[i], localLCM));
                }

                lcm[mask] = localLCM;
            }

            long left = k, right = (long) coins[0] * k + 1;

            while (left < right) {
                long mid = left + (right - left) / 2;

                if (countK(lcm, k, mid)) right = mid;
                else left = mid + 1;
            }

            return left;
        }

        // 1 == count increased the mid, 0 means equal, -1 count is smaller then mid
        private boolean countK(long[] lcm, int coinToLeft, long mid) {
            long count = 0;

            for (int i = 1; i < lcm.length; i++) {
                if (lcm[i] > mid) continue;
                int bitCount = Integer.bitCount(i);

                if (bitCount % 2 == 0) count -= (mid / lcm[i]);
                else count += (mid / lcm[i]);
            }

            return count >= coinToLeft;
        }

        private long GCD(long a, long b) {
            if (b == 0) return a;
            else return GCD(b, a % b);
        }

    }

}
