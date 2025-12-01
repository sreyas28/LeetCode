import java.util.*;

public class ProblemNo1590 {
    public static void main(String[] args) {

        ProblemNo1590.Solution a = new ProblemNo1590().new Solution();
        System.out.println(a.minSubarray(new int[]{3,1,3}, 3));

    }

    class Solution {
        public int minSubarray(int[] nums, int p) {
            long total = 0;
            for (int num : nums) total += num;
            int target = (int)(total % p);
            if (target == 0) return 0;

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1); // prefix sum mod p at index -1
            long prefix = 0;
            int res = nums.length;

            for (int i = 0; i < nums.length; i++) {
                prefix += nums[i];
                int mod = (int)(prefix % p);
                int need = (mod - target + p) % p;

                if (map.containsKey(need)) {
                    res = Math.min(res, i - map.get(need));
                }
                map.put(mod, i);
            }

            return res == nums.length ? -1 : res;
        }
    }
}
