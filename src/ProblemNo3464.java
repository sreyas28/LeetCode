import java.util.*;

public class ProblemNo3464 {
    public static void main(String[] args) {

        ProblemNo3464.Solution a = new ProblemNo3464().new Solution();
        System.out.println(a.maxDistance(2, new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 2}, {2, 1}}, 5));

    }

    class Solution {
        public int maxDistance(int side, int[][] points, int k) {
            List<Long> flattenPoints = new ArrayList<>();
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];

                if (x == 0) flattenPoints.add((long) y);
                else if (y == side) flattenPoints.add((long) (side + x));
                else if (x == side) flattenPoints.add(side * 2L + (long) (side - y));
                else if (y == 0) flattenPoints.add(side * 3L + (long) (side - x));
            }
            Collections.sort(flattenPoints);

            long left = 0, right = (long)side;
            int ans = 0;
            while (left <= right) {
                long mid = left + (right - left) / 2;

                if (check(mid, k, side, flattenPoints)) {
                    ans = (int) mid;
                    left = mid + 1;
                }
                else right = mid - 1;
            }

            return ans;
        }

        private boolean check(long gap, int noSelection, int side, List<Long> flattenPoints) {
            long perimeter = side * 4L;

            for (long start : flattenPoints) {
                long end = start + perimeter - gap;
                long cur = start;

                for (int i = 0; i < noSelection - 1; i++) {
                    int idx = binarySearch(cur + gap, flattenPoints);
                    if (idx == flattenPoints.size() || flattenPoints.get(idx) > end) {
                        cur = -1;
                        break;
                    }
                    cur = flattenPoints.get(idx);
                }

                if (cur >= 0) {
                    return true;
                }
            }
            return false;
        }

        private int binarySearch(long toFind, List<Long> flattenPoints) {
            int left = 0;
            int right = flattenPoints.size();

            while (left < right) {
                int  mid = left + (right - left) / 2;

                if  (flattenPoints.get(mid) < toFind) left = mid + 1;
                else right = mid;
            }

            return left;
        }
    }

}
