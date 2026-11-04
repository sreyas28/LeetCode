import java.util.*;

public class ProblemNo3505 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3505().new Solution();
        System.out.println(a.minOperations(new int[]{5, -2, 1, 3, 7, 3, 6, 4, -1}, 3, 2));

    }

    class Solution {
        private final Queue<Integer> lowSide = new PriorityQueue<>(Collections.reverseOrder());
        private final Queue<Integer> highSide = new PriorityQueue<>();

        private final Map<Integer, Integer> delay = new HashMap<>();

        private long lowSum = 0, hiSum = 0;
        private int lowSize = 0, hiSize = 0;

        public long minOperations(int[] nums, int x, int k) {
            final int N = nums.length;
            long[] costs = windowCost(nums, x);

            final long INF = Long.MAX_VALUE / 2;
            long[][] dp = new long[k + 1][N];
            for (int i = 1; i <= k; i++) Arrays.fill(dp[i], INF);   // dp[0][*] = 0

            for (int i = 1; i <= k; i++) {
                for (int j = x - 1; j < N; j++) {
                    long skip = dp[i][j - 1];                        // j-1 >= 0 since x >= 2

                    long prev;
                    if (j - x >= 0) prev = dp[i - 1][j - x];
                    else prev = (i == 1) ? 0 : INF;                  // nothing before the window

                    long take = (prev >= INF) ? INF : prev + costs[j - x + 1];
                    dp[i][j] = Math.min(skip, take);
                }
            }
            return dp[k][N - 1];
        }

        private long[] windowCost(int[] nums, int x) {
            final int N = nums.length;
            long[] cost = new long[N - x + 1];

            for (int i = 0; i < N; i++) {
                add(nums[i]);

                if (i >= x) remove(nums[i - x]);
                if (i >= x - 1 && !lowSide.isEmpty()) {
                    int median = lowSide.peek();
                    cost[i - x + 1] = ((long) median * lowSize - lowSum) + (hiSum - (long) median * hiSize);
                }

            }

            return cost;
        }

        private void add(int val) {
            if (lowSide.isEmpty() || lowSide.peek() >= val) {
                lowSide.add(val);
                lowSum += val;
                lowSize++;
            } else {
                highSide.add(val);
                hiSum += val;
                hiSize++;
            }

            rebalance();
        }

        private void rebalance() {
            if (!lowSide.isEmpty() && lowSize > hiSize + 1) {
                int val = lowSide.poll();
                lowSum -= val;
                lowSize--;

                highSide.add(val);
                hiSum += val;
                hiSize++;

                prune(lowSide);
            } else if (!highSide.isEmpty() && lowSize < hiSize) {
                int val = highSide.poll();
                hiSum -= val;
                hiSize--;

                lowSide.add(val);
                lowSum += val;
                lowSize++;

                prune(highSide);
            }
        }

        private void prune(Queue<Integer> queue) {
            while (!queue.isEmpty()) {
                int peek = queue.peek();
                int count = delay.getOrDefault(peek, 0);

                if (count == 0) break;
                else if (count == 1) delay.remove(peek);
                else delay.put(peek, count - 1);

                queue.poll();
            }
        }

        private void remove(int val) {
            delay.put(val, delay.getOrDefault(val, 0) + 1);

            if (!lowSide.isEmpty() && lowSide.peek() >= val) {
                lowSum -= val;
                lowSize--;

                if (lowSide.peek() == val) prune(lowSide);
            } else if (!highSide.isEmpty()) {
                hiSum -= val;
                hiSize--;

                if (highSide.peek() == val) prune(highSide);
            }

            rebalance();
        }

    }

}
