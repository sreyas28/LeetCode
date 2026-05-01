public class ProblemNo396 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxRotateFunction(int[] nums) {
            final int n = nums.length;
            int totalSum = 0;

            int currentSum = 0;
            for (int i = 0; i < n; i++) {
                currentSum += i * nums[i];
                totalSum += nums[i];
            }

            int max = currentSum;

            for (int i = n-1; i >= 1; i--) {

                int additive = totalSum - nums[(i+1) % n] - nums[i];

                currentSum = currentSum + nums[(i+1) % n] - ((n-1) * nums[i]) + additive;
                max = Math.max(max, currentSum);
            }

            return max;
        }
    }

}
