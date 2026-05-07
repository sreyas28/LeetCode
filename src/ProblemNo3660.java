import java.io.Console;
import java.util.Arrays;

public class ProblemNo3660 {

    public static void main(String[] args) {

        Solution a = new ProblemNo3660().new Solution();
//        System.out.println(Arrays.toString(a.maxValue(new int[]{6, 5, 4, 9, 1, 2, 3, 7})));
        System.out.println(Arrays.toString(a.maxValue(new int[]{11, 18, 11})));

    }

    class Solution {
        public int[] maxValue(int[] nums) {
            final int n = nums.length;

            int[] max = new int[n];
            int[] min = new int[n];

            max[0] = nums[0];
            min[n - 1] = nums[n - 1];

            for (int i = 1; i < n; i++) {

                if (nums[i] > max[i - 1]) max[i] = nums[i];
                else max[i] = max[i - 1];

                int index = n - i - 1;

                if (nums[index] < min[index + 1]) min[index] = nums[index];
                else min[index] = min[index + 1];
            }

            int[] ans = new int[n];
            ans[n - 1] = max[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                if(max[i] > min[i+1]) ans[i] = ans[i+1];
                else ans[i] = max[i];
            }

            return ans;
        }

    }

}

