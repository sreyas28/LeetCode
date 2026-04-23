import java.util.*;

public class ProblemNo2615 {
    public static void main(String[] args) {

    }

    class Solution {
        public long[] distance(int[] nums) {
            final int n = nums.length;

            Map<Integer, List<Integer>> num_place = new HashMap<>();
            for (int i = 0; i < n; i++) {
                num_place.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
            }

            long[] res = new long[n];
            for (List<Integer> list : num_place.values()) {
                long total = 0;
                for (int idx : list) total += idx;

                int nz = list.size();

                long prefix = 0;
                for (int i = 0; i < nz; i++) {
                    int idx = list.get(i);

                    res[idx] = total - 2 * prefix + (long) idx * (2L * i - nz);
                    prefix += idx;
                }

            }

            return res;
        }
    }

}
