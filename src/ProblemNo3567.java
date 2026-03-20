import java.util.*;

public class ProblemNo3567 {
    public static void main(String[] args) {

        ProblemNo3567.Solution p = new ProblemNo3567().new Solution();
        System.out.println(Arrays.deepToString(p.minAbsDiff(new int[][]{{1, -2, 3}, {2, 3, 5}}, 2)));
    }

    class Solution {
        public int[][] minAbsDiff(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            int[][] res = new int[m - k + 1][n - k + 1];

            if (k == 1) return res;

            for (int i = 0; i < m - k + 1; i++) {
                for (int j = 0; j < n - k + 1; j++) {
                    res[i][j] = runner(i, j, grid, k);
                }
            }

            return res;
        }

        private int runner(int i, int j, int[][] grid, int k) {
            Set<Integer> set = new TreeSet<>();
            for (int r = i; r < i + k; r++) {
                for (int c = j; c < j + k; c++) {
                    set.add(grid[r][c]);
                }
            }
            return smallestDiff(set);
        }

        private int smallestDiff(Set<Integer> set) {
            if (set.size() == 1) return 0;

            int min = Integer.MAX_VALUE;
            Iterator<Integer> iterator = set.iterator();
            Integer prev = null;

            while (iterator.hasNext()) {
                int next = iterator.next();
                if (prev != null) min = Math.min(min, next - prev);
                prev = next;
            }

            return min;
        }

    }

}
