import java.util.Arrays;

public class ProblemNo2567 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minimizeSum(int[] nums) {
            final int N = nums.length;
            if (N == 3) return 0;

            Arrays.sort(nums);

            int min = nums[N - 2] - nums[1];
            min = Math.min(min, nums[N-1] - nums[2]);
            min = Math.min(min, nums[N-3] - nums[0]);


            return min;
        }
    }

}
