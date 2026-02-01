public class ProblemNo3010 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minimumCost(int[] nums) {
            int min_1 = nums[0];
            int min_2 = Integer.MAX_VALUE;
            int min_3 = Integer.MIN_VALUE;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < min_2) {
                    min_3 = min_2;
                    min_2 = nums[i];
                }
                else if (nums[i] < min_3) {
                    min_3 = nums[i];
                }
            }

            return min_1 + min_2 + min_3;
        }
    }

}
