import java.util.*;

public class ProblemNo3741 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minimumDistance(int[] nums) {
            if (nums.length < 3) return -1;

            int minVal = Integer.MAX_VALUE;

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
            }

            for (int key : map.keySet()) {
                List<Integer> list = map.get(key);
                if (list.size() < 3) continue;

                Collections.sort(list);
                for (int i = 2; i < list.size(); i++) {
                    minVal = Math.min(minVal, 2 * (list.get(i) - list.get(i - 2)));
                }
            }

            return minVal == Integer.MAX_VALUE ? -1 : minVal;
        }
    }

}
