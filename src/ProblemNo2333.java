import java.util.Arrays;
import java.util.Comparator;

public class ProblemNo2333 {

    public static void main(String[] args) {

        Solution a = new ProblemNo2333().new Solution();
        System.out.println(a.minSumSquareDiff(new int[]{1, 4, 10, 12}, new int[]{5, 8, 6, 9}, 1, 1));

    }

    class Solution {
        public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
            final int N = nums1.length;
            final long k = k1 + k2;

            long sum = 0;
            int high = 0, low = 0;

            for (int i = 0; i < N; i++) {
                nums1[i] = (Math.abs(nums1[i] - nums2[i]));
                high = Math.max(high, nums1[i]);

                sum += nums1[i];
            }

            if (sum <= k) return 0;

            int plateau = 0, rem = 0;
            while (high >= low) {
                int mid = low + (high - low) / 2;
                long cost = cost(nums1, mid);

                if (cost <= k) {
                    high = mid - 1;
                    plateau = mid;
                    rem = (int) (k - cost);

                } else low = mid + 1;
            }

            // flatten up
            for(int i = 0; i < N; i++) nums1[i] = Math.min(plateau, nums1[i]);
            Arrays.sort(nums1);

            long res = 0;
            for (int i = N-1; i >= 0; i--) {
                int temp = nums1[i] - (rem-- > 0 ? 1 : 0);
                res += ((long) temp * temp);
            }

            return res;
        }

        private long cost(int[] arr, int minus) {
            long sum = 0;
            for (int num : arr) {
                sum += Math.max(0, num - minus);
            }

            return sum;
        }

    }


}
