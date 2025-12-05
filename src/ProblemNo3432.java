public class ProblemNo3432 {
    public static void main(String[] args) {

    }

    class Solution {
        public int countPartitions(int[] nums) {
            int result = 0, sum = 0;
            for(int i: nums) sum += i;

            int preSum = 0;
            for(int i = 1; i<nums.length; i++){
                preSum += nums[i-1];
                sum -= nums[i-1];

                if((preSum - sum) % 2 == 0) result++;
            }

            return result;
        }
    }
}
