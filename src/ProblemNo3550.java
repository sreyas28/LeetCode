public class ProblemNo3550 {

    public static void main(String[] args) {
        Solution a = new ProblemNo3550().new Solution();
        System.out.println(a.smallestIndex(new int[]{1, 10, 11}));
    }

    class Solution {
        public int smallestIndex(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (i == sum(nums[i])) return i;
            }
            return -1;
        }

        private int sum(int nums) {
            int sum = 0;

            while (nums > 0) {
                sum += nums % 10;
                nums /= 10;
            }

            return sum;
        }

    }

}
