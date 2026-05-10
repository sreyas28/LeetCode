public class ProblemNo2770 {

    public static void main(String[] args) {

        Solution a = new ProblemNo2770().new Solution();
        System.out.println(a.maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));

    }

    class Solution {
        private Integer[][] DP;

        public int maximumJumps(int[] nums, int target) {
            DP = new Integer[nums.length + 1][nums.length + 1];

            return recursionBackTracking(-1, 0, nums, target);
        }


        private int recursionBackTracking(int previous, int current, int[] num, int target) {
            int prevVal = previous >= 0 ? num[previous] : num[current];
            if (Math.abs(num[current] - prevVal) > target) return -1; // when it is not possible

            if (current == num.length - 1) return 0;

            if (DP[previous + 1][current + 1] != null) return DP[previous + 1][current + 1];

            int val = -1;
            for (int i = current + 1; i < num.length; i++) {
                int temp = recursionBackTracking(current, i, num, target);
                if (temp != -1) val = Math.max(val, temp + 1);
            }

            DP[previous + 1][current + 1] = val; // +1 because, as i am taking -1 as previous in start
            return val;
        }

    }

}
