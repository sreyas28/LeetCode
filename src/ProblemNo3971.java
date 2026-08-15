import java.util.PriorityQueue;

public class ProblemNo3971 {
    public static void main(String[] args) {

    }

    class Solution {
        static final long MOD = 1_000_000_007L;

        public int maxTotalValue(int[] value, int[] decay, int m) {
            int n = value.length;

            long lo = 1, hi = 1_000_000_000L;
            long threshold = 0;

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;

                if (countTerms(value, decay, mid, m) >= m) {
                    threshold = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            long sum = 0;
            long used = 0;

            for (int i = 0; i < n; i++) {
                long a = value[i];
                long d = decay[i];

                if (a <= threshold) continue;

                long cnt = (a - (threshold + 1)) / d + 1;
                used += cnt;

                long last = a - (cnt - 1) * d;
                sum += cnt * (a + last) / 2;
            }

            long remaining = m - used;
            sum += remaining * threshold;

            return (int)(sum % MOD);
        }

        private long countTerms(int[] value, int[] decay, long x, int m) {
            long cnt = 0;

            for (int i = 0; i < value.length; i++) {
                if (value[i] < x) continue;

                cnt += (value[i] - x) / (long) decay[i] + 1;

                if (cnt >= m) return cnt;
            }

            return cnt;
        }
    }

    class Solution_ {
        public int maxTotalValue(int[] value, int[] decay, int m) {
            final int N = value.length;
            final int MOD = 1_000_000_007;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

            for (int i = 0; i < N; i++) pq.offer(new int[]{value[i], decay[i]});

            int sum = 0;
            for (int i = 0; i < m && !pq.isEmpty(); i++) {
                int[] cur = pq.poll();

                sum = (sum + cur[0]) % MOD;

                cur[0] -= cur[1];
                if (cur[0] > 0) pq.offer(cur);
            }


            return sum;
        }
    }

}
