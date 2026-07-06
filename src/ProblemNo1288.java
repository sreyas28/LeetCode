import java.util.*;

public class ProblemNo1288 {
    public static void main(String[] args) {

        Solution solution = new ProblemNo1288().new Solution();
        System.out.println(solution.removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));

    }

    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            List<int[]> list = new LinkedList<>();
            Arrays.sort(intervals, (a,b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return b[1] - a[1];
            });


            for (int[] interval : intervals) {
                if (list.isEmpty()) {
                    list.add(interval);
                    continue;
                }

                int[] last = list.getLast();
                int left = interval[0], right = interval[1];
                if (last[0] <= left && left <= last[1] && last[0] <= right && right <= last[1]) continue;

                list.add(interval);
            }


            return list.size();
        }
    }

}
