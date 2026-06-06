import java.util.Arrays;

public class ProblemNo2574 {
    public static void main(String[] args) {

        Solution solution = new ProblemNo2574().new Solution();
        System.out.println(Arrays.toString(solution.leftRightDifference(new int[]{10, 4, 8, 3})));

    }

    class Solution {
        public int[] leftRightDifference(int[] nums) {
            int[] prefixSum =  new int[nums.length];
            int[] res =  new int[nums.length];

            for(int i = 1; i < nums.length; i++) prefixSum[i] += nums[i-1] + prefixSum[i-1];

            int prev = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                res[i] = Math.abs(prefixSum[i] - prev);
                prev += nums[i];
            }

            return res;
        }
    }

}
