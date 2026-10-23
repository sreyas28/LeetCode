import java.util.Arrays;

public class ProblemNo3644 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3644().new Solution();
        System.out.println(a.sortPermutation(new int[]{0, 3, 2, 1}));
//        System.out.println(a.sortPermutation(new int[]{0, 1, 3, 2}));
//        System.out.println(a.sortPermutation(new int[]{3, 2, 1, 0}));

//        System.out.println(a.sortPermutation(new int[]{3, 2, 1, 0, 4, 9, 5, 8, 6, 7}));

    }

    class Solution {
        public int sortPermutation(int[] nums) {
            final int N = nums.length;

            int k = -1;
            for (int i = 0; i < N; i++) {
                if (nums[i] != i) {
                    if (k == -1) k = nums[i];
                    else k &= nums[i];
                }
            }

            return k == -1 ? 0 : k;
        }
    }

}
