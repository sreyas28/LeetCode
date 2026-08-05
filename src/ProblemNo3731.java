import java.util.*;

public class ProblemNo3731 {

    class Solution {
        public List<Integer> findMissingElements(int[] nums) {
            Arrays.sort(nums);
            List<Integer> ans = new ArrayList<>();

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == 1)
                    continue;

                for (int j = nums[i - 1] + 1; j < nums[i]; j++)
                    ans.add(j);

            }

            return ans;
        }
    }

}
