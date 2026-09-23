public class ProblemNo1658 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1658().new Solution();
//        System.out.println(a.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
//        System.out.println(a.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
        System.out.println(a.minOperations(new int[]{7, 6, 1, 2, 8}, 5));

    }

    class Solution {
        public int minOperations(int[] nums, int x) {
            final int N = nums.length;
            int total = 0;
            for (int num : nums) total += num;

            int toFind = total - x;
            if (toFind < 0) return -1;

            int cur = 0, left = 0, max = -1;
            for (int right = 0; right < N; right++) {
                cur += nums[right];

                while (cur > toFind) {
                    cur -= nums[left];
                    left++;
                }

                if (cur == toFind) max = Math.max(max, right - left + 1);
            }

            return max == -1 ? -1 : N - max;
        }
    }


    // working but bit slow
    class Solution__ {
        public int minOperations(int[] nums, int x) {
            final int N = nums.length;
            int[] prefixSum = new int[N];
            prefixSum[0] = nums[0];

            for (int i = 1; i < N; i++) prefixSum[i] = nums[i] + prefixSum[i - 1];

            int toFind = prefixSum[N - 1] - x;
            int min = Integer.MAX_VALUE;

            int left = 0;
            for (int right = 0; right < N; right++) {
                int cur = prefixSum[right] - (left - 1 >= 0 ? prefixSum[left-1] : 0);

                while (cur > toFind && left <= right) {
                    left++;
                    cur = prefixSum[right] - (left - 1 >= 0 ? prefixSum[left-1] : 0);
                }

                if (cur == toFind) {
                    min = Math.min(min, N - (right - left + 1));
                }
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }

    // Brute Force
    class Solution_ {
        public int minOperations(int[] nums, int x) {
            int ans = chooser(0, nums.length - 1, nums, 0, x);

            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        private int chooser(int i, int j, int[] nums, int count, int x) {
            if (x == 0) return count;
            else if (i > j) return Integer.MAX_VALUE;

            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

            if (nums[i] <= x) left = chooser(i + 1, j, nums, count + 1, x - nums[i]); // left
            if (nums[j] <= x) right = chooser(i, j - 1, nums, count + 1, x - nums[j]); // right

            return Math.min(left, right);
        }

    }

}
