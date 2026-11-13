import java.util.Arrays;

public class ProblemNo3402 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3402().new Solution();
        System.out.println(a.minimumOperations(new int[][]{{3, 2}, {1, 3}, {3, 4}, {0, 1}}));

    }

    class Solution {
        public int minimumOperations(int[][] grid) {
            final int rowLen = grid[0].length;
            int[] maxes = new int[rowLen];
            Arrays.fill(maxes, -1);

            int count = 0;

            for (int[] row : grid) {

                for (int i = 0; i < rowLen; i++) {
                    if (row[i] > maxes[i]) maxes[i] = row[i];
                    else {
                        maxes[i]++;
                        count += maxes[i] - row[i];
                    }
                }
            }

            return count;
        }
    }

}
