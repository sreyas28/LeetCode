public class ProblemNo2091 {
    public static void main(String[] args) {
        Solution a = new ProblemNo2091().new Solution();
        System.out.println(a.minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}));
        System.out.println(a.minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5}));
        System.out.println(a.minimumDeletions(new int[]{101}));
    }

    class Solution {
        public int minimumDeletions(int[] nums) {
            final int N = nums.length;
            int min = 0, max = 0;

            for (int i = 1; i < N; i++) {
                if (nums[i] > nums[max]) max = i;
                else if (nums[i] < nums[min]) min = i;
            }

            int changes = 0;

            if (min > max) {
                int option1 = max + 1 + (N - min);
                int option2 = Math.min(N - max, min + 1);

                changes = Math.min(option1, option2);
            } else {
                int option1 = (N - max) + min + 1;
                int option2 = Math.min(max + 1, N - min);

                changes = Math.min(option1, option2);
            }

            return changes;
        }
    }

}
