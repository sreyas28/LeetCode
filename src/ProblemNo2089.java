import java.util.*;

public class ProblemNo2089 {
    class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {

            int lower = 0, count = 0;
            for (int i : nums) {
                if (i < target) lower++;
                else if (i == target) count++;
            }

            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < count; i++) res.add(lower++);

            return res;
        }
    }
}
