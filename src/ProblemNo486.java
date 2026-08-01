import java.util.Arrays;

public class ProblemNo486 {
    public static void main(String[] args) {

        Solution a = new ProblemNo486().new Solution();
        System.out.println(a.predictTheWinner(new int[]{2, 4, 55, 6, 8}));

    }

    class Solution {
        public boolean predictTheWinner(int[] nums) {
            long sum = Arrays.stream(nums).sum();
            long p1Score = recursionP1(0, nums.length - 1, nums);

            return (p1Score >= sum - p1Score);
        }

        private long recursionP1(int l, int r, int[] nums) {
            if (l == r) return nums[l];

            long leftSum = recursionP2(l + 1, r, nums) + nums[l];
            long rightSum = recursionP2(l, r - 1, nums) + nums[r];

            return Math.max(leftSum, rightSum);
        }

        private long recursionP2(int l, int r, int[] nums) {
            if (l == r) return nums[l];

            long leftSum = recursionP1(l + 1, r, nums);
            long rightSum = recursionP1(l, r - 1, nums);

            return Math.min(leftSum, rightSum);
        }

    }

}
