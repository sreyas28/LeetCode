public class ProblemNo3689 {
    public static void main(String[] args) {

    }

    class Solution {
        public long maxTotalValue(int[] nums, int k) {
            int min = nums[0], max = nums[0];

            for(int value : nums){
                min = Math.min(min, value);
                max = Math.max(max, value);
            }

            return (long) (max - min) * k;
        }
    }

}

