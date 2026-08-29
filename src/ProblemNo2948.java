import java.util.*;

public class ProblemNo2948 {
    public static void main(String[] args) {

        Solution solution = new ProblemNo2948().new Solution();
//        System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(new int[]{1, 5, 3, 9, 8}, 2)));
        System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(new int[]{1, 7, 28, 19, 10}, 3)));

    }

    class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            final int n = nums.length;

            // clone maps index of original array to cloned one
            int[][] clone = new int[n][2]; // index, value
            for (int i = 0; i < n; i++) {
                clone[i][0] = i;
                clone[i][1] = nums[i];
            }
            Arrays.sort(clone, (a, b) -> a[1] - b[1]);

            // give me group for each index
            int[] groups = groupMaker(clone, limit);
            Map<Integer, PriorityQueue<Integer>> groupToNumbers = groupToNumber(nums, groups);

            for (int i = 0; i < n; i++) {
                int group = groups[i];
                int updator = groupToNumbers.get(group).poll();

                nums[i] = updator;
            }

            return nums;
        }

        private int[] groupMaker(int[][] nums, int limit) {
            int[] group = new int[nums.length];
            int groupNumber = 0;
            group[0] = groupNumber;

            for (int i = 1; i < nums.length; i++) {
                int idx = nums[i][0];

                if (nums[i][1] - nums[i - 1][1] <= limit) group[idx] = groupNumber;
                else group[idx] = ++groupNumber;
            }

            return group;
        }

        private Map<Integer, PriorityQueue<Integer>> groupToNumber(int[] nums, int[] groups) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int group = groups[i];
                int value = nums[i];

                map.computeIfAbsent(group, k -> new PriorityQueue<>((a, b) -> a - b)).offer(value);
            }

            return map;
        }

    }

}
