import java.util.Arrays;

public class ProblemNo1984 {
    public static void main(String[] args) {
        ProblemNo1984.Solution p = new ProblemNo1984().new Solution();
        System.out.println(p.minimumDifference(new int[]{9,4,1,7}, 3));
    }

    class Solution {
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);

            int ans = Integer.MAX_VALUE;

            for (int end = nums.length-1; end - k + 1 >= 0; end--) {
                ans = Math.min(ans, Math.abs(nums[end] - nums[end - k + 1]));
            }

            return ans;
        }
    }

}
