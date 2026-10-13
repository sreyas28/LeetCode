import java.util.Arrays;

public class ProblemNo3727 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3727().new Solution();
        System.out.println(a.maxAlternatingSum(new int[]{-1,2,-2,3,-3}));

    }

    class Solution {
        public long maxAlternatingSum(int[] nums) {
            final int N = nums.length;

            for (int i = 0; i < N; i++) nums[i] = Math.abs(nums[i]);
            Arrays.sort(nums);

            long res = (N % 2 == 0) ? 0 : (long) Math.pow(nums[N / 2], 2);
            for (int i = 0; i < N / 2; i++) {
                res = (long) (res + Math.pow(nums[nums.length - i - 1], 2));
                res = (long) (res - Math.pow(nums[i], 2));
            }

            return res;
        }
    }

}
