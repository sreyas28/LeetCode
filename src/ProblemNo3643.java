import java.util.Arrays;

public class ProblemNo3643 {
    public static void main(String[] args) {

        ProblemNo3643.Solution p = new ProblemNo3643().new Solution();
        System.out.println(Arrays.deepToString(p.reverseSubmatrix(new int[][]{{6,16,14},{1,2,19},{14,17,15},{18,7,6},{14,12,5}}, 2, 1, 2)));

    }

    class Solution {
        public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
            int rangeX = x + k - 1, rangeY = y + k - 1;

            while ( x < rangeX ) {
                for (int j = y; j <= rangeY; j++) {
                    int temp = grid[x][j];
                    grid[x][j] = grid[rangeX][j];
                    grid[rangeX][j] = temp;
                }
                x++;
                rangeX--;
            }

            return grid;
        }
    }

}
