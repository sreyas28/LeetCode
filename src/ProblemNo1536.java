import java.util.Arrays;
import java.util.Collections;

public class ProblemNo1536 {
    public static void main(String[] args) {

        ProblemNo1536.Solution p = new ProblemNo1536().new Solution();
        System.out.println(p.minSwaps(new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}}));

    }

    class Solution {
        public int minSwaps(int[][] grid) {
            int n = grid.length;

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if (grid[i][j] == 0) array[i]++;
                    else break;
                }
            }

//            System.out.println(Arrays.toString(array));

            int operations = 0;
            for (int row = 0; row < n; row++) {
                int minToFind = n - row - 1;
                if (array[row] >= minToFind) continue;

                int indexToChange = indexFinder(row, array, minToFind, n);
                if (indexToChange == -1) return -1;

                operations += swapper(array, indexToChange, row);
            }

            return operations;
        }

        private int indexFinder(int row, int[] array, int minToFind, int n) {
            int indexToChange = -1;
            for (int iTH = row + 1; iTH < n; iTH++) {
                if (array[iTH] >= minToFind) {
                    indexToChange = iTH;
                    break;
                }
            }
            return indexToChange;
        }

        private int swapper(int[] array, int from, int to) {
            int operations = 0;
            for (int i = from; i > to; i--) {
                int temp =  array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                operations++;
            }

            return operations;
        }

    }

}
