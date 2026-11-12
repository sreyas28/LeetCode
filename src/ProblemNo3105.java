public class ProblemNo3105 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int incr = 1, decr = 1;
            int max = 1;

            for (int i = 0; i < nums.length - 1; i++) {

                if (nums[i] > nums[i + 1]) {
                    decr++;
                    incr = 1;
                } else if (nums[i] < nums[i + 1]) {
                    incr++;
                    decr = 1;
                } else {
                    incr = 1;
                    decr = 1;
                }

                max = Math.max(Math.max(incr, decr), max);
            }

            return max;
        }
    }

}
