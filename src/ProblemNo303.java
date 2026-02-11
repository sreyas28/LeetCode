public class ProblemNo303 {
    public static void main(String[] args) {

    }
    class NumArray {
        long[] vals;

        public NumArray(int[] nums) {
            vals = new long[nums.length];
            vals[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                vals[i] = vals[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return (int) (vals[right] - (left - 1 >= 0 ? vals[left - 1] : 0));
        }
    }

}
