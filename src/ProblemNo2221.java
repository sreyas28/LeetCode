public class ProblemNo2221 {
    public static void main(String[] args) {

    }

    class Solution {
        public int triangularSum(int[] nums) {

            for(int row = 0; row < nums.length; row++){
                for(int val = 1; val < nums.length - row; val++){
                    nums[val-1] = (nums[val-1] + nums[val]) % 10;
                }
            }

            return nums[0] % 10;
        }
    }

}
