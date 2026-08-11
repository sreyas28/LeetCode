import java.util.HashSet;
import java.util.Set;

public class ProblemNo2996 {
    public static void main(String[] args) {
        Solution a = new ProblemNo2996().new Solution();
        System.out.println(a.missingInteger(new int[]{1, 2, 6, 3, 4, 5}));
    }

    class Solution {
        public int missingInteger(int[] nums) {
            Set<Integer> set = new HashSet<>();
            set.add(nums[0]);
            int prefixSum = nums[0];
            boolean flag = true;
            for (int i = 1; i < nums.length; i++) {
                if (flag && nums[i] == nums[i - 1] + 1) prefixSum += nums[i];
                else flag = false;

                set.add(nums[i]);
            }

            for (int i = prefixSum; ; i++) {
                if (!set.contains(i)) return i;
            }
        }
    }

}
