import java.util.Arrays;

public class ProblemNo453 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minMoves(int[] nums) {
            if (nums == null || nums.length <= 1) return 0;

            int min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                }
            }

            int count = 0;
            for (int num : nums) {
                count += num - min;
            }

            return count;
        }
    }

}
