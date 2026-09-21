import java.util.Arrays;

public class ProblemNo3524 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3524().new Solution();
//        System.out.println(Arrays.toString(a.resultArray(new int[]{78,71,26,24,81,51,46,29,45,77,83,72,79,74,8,34,49,63,69,39,81,61,88,35,59,45,21,72,98,10,48,34,3,11,16,50,53,21,83,96,53,5,94}, 5)));
        System.out.println(Arrays.toString(a.resultArray(new int[]{1, 2, 3, 4, 5}, 3)));
    }

    class Solution {
        public long[] resultArray(int[] nums, int k) {
            long[] prev = new long[k];
            long[] res = new long[k];

            for (long curNum : nums) {
                long[] cur = new long[k];
                cur[(int) (curNum % k)]++;

                for (int r = 0; r < k; r++) cur[(int) ((r * curNum) % k)] += prev[r];

                prev = cur;
                for (int r = 0; r < k; r++) res[r] += cur[r];
            }

            return res;
        }
    }

    // yep it is brute Force
    class Solution_ {
        public long[] resultArray(int[] nums, int k) {
            long[] res = new long[k];

            for (int i = 0; i < nums.length; i++) {
                long product = 1;
                for (int j = i; j < nums.length; j++) {
                    product *= nums[j];

                    int idx = (int) (product % k);
                    product = idx;
                    res[idx]++;
                }
            }

            return res;
        }
    }

}
