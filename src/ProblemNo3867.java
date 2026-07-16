import java.util.Arrays;

public class ProblemNo3867 {


    class Solution {
        public long gcdSum(int[] nums) {
            final int n = nums.length;
            int max = nums[0];

            int[] prefixGCD = new int[n];
            prefixGCD[0] = nums[0];

            for (int i = 1; i < n; i++) {
                max = Math.max(max, nums[i]);
                prefixGCD[i] = GCD(max, nums[i]);
            }

            Arrays.sort(prefixGCD);
            long sum = 0;
            for (int i = 0; i < n / 2; i++) {
                sum += GCD(prefixGCD[i], prefixGCD[n - i - 1]);
            }

            return sum;
        }

        private int GCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

    }

}
