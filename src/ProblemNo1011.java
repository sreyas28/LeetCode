public class ProblemNo1011 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1011().new Solution();
        System.out.println(a.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));

    }

    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            final int N = weights.length;

            int[] prefixSums = new int[N+1];
            int max = 0;

            for (int i = 0; i < N; i++) {
                prefixSums[i+1] = weights[i] + prefixSums[i];
                max = Math.max(max, weights[i]);
            }

            int left = max, right = prefixSums[N];
            int ans = -1;

            while (left <= right) {
                int maxCapacity = left + (right - left) / 2;

                if (feasible(prefixSums, maxCapacity, days)) {
                    ans = maxCapacity;
                    right = maxCapacity - 1;
                }
                else left = maxCapacity + 1;
            }


            return ans;
        }

        private boolean feasible(int[] prefixSum, int capacity, int days) {
            final int N = prefixSum.length;
            int offsetIndex = 0, lastLow = 0, daysCount = 0;

            while (lastLow < N) {

                int offset = prefixSum[offsetIndex];
                int left = lastLow, right = N - 1;
                int ans = -1;
                daysCount++;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (prefixSum[mid] - offset <= capacity) {
                        left = mid + 1;
                        ans = mid;
                    }
                    else right = mid - 1;
                }
                offsetIndex = ans;
                lastLow = ans + 1;
            }

            return daysCount <= days;
        }

    }

}
