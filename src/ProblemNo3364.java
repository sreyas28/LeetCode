import java.util.*;

public class ProblemNo3364 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3364().new Solution();

        int[] arr = {-23, 2, -12};
        List<Integer> arrList = new ArrayList<>();

        for (int i : arr) arrList.add(i);

        System.out.println(a.minimumSumSubarray(arrList, 1, 2));
    }

    class Solution {
        public int minimumSumSubarray(List<Integer> nums, int l, int r) {
            final int N = nums.size();
            int[] prefixSums = new int[N + 1];

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) prefixSums[i + 1] = prefixSums[i] + nums.get(i);

            for (int k = l; k <= r; k++) {
                for (int i = 0; i + k <= N; i++) {
                    int sum = prefixSums[i + k] - prefixSums[i];
                    if (sum > 0) min = Math.min(min, sum);
                }
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }

}
