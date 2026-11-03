public class ProblemNo3736 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minMoves(int[] nums) {
            if (nums == null || nums.length <= 1) return 0;

            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }

            int count = 0;
            for (int num : nums) {
                count += max - num;
            }

            return count;
        }
    }

}
