import java.util.*;

public class ProblemNo3739 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3739().new Solution();
        System.out.println(a.countMajoritySubarrays(new int[]{1, 2, 2, 1}, 2));

    }

    class Solution {
        public long countMajoritySubarrays(int[] nums, int target) {

            for (int i = 0; i < nums.length; i++) nums[i] = nums[i] == target ? 1 : -1;

            int prefix = 0;
            long result = 0;

            List<Integer> seen = new ArrayList<>();
            seen.add(0);

            for (int num : nums) {
                prefix += num;

                int idx = bisect(seen, prefix);
                result += idx;

                seen.add(idx, prefix);
            }

            return result;
        }

        private int bisect(List<Integer> seen, int target) {
            int left = 0;
            int right = seen.size();
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (target <= seen.get(mid)) right = mid;
                else left = mid + 1;
            }

            return left;
        }

    }

}
