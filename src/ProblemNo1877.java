import java.util.Arrays;

public class ProblemNo1877 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);

            int maxSum = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length/2; i++){
                maxSum = Math.max(maxSum, nums[i] + nums[nums.length-i-1]);
            }

            return maxSum;
        }
    }

}
