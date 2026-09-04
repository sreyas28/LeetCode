public class ProblemNo3903 {

    public static void main(String[] args) {

        Solution a = new ProblemNo3903().new Solution();
        System.out.println(a.firstStableIndex(new int[]{6,1,4}, 5));

    }

    class Solution {
        public int firstStableIndex(int[] nums, int k) {
            final int N = nums.length;

            int[] mins = new int[N];
            mins[N - 1] = nums[N - 1];
            for (int i = N - 2; i >= 0; i--) mins[i] = Math.min(nums[i], mins[i + 1]);

            int max = nums[0];
            for (int i = 0; i < N; i++) {
                max = Math.max(max, nums[i]);
                int tempVal = max - mins[i];

                if (tempVal > k) continue;
                return i;
            }

            return -1;
        }
    }

}
