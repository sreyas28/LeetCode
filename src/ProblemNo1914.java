import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemNo1914 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1914().new Solution();
        System.out.println(Arrays.deepToString(a.rotateGrid(new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
        }, 2)));

    }

    class Solution {
        private int ROWS, COLS;

        public int[][] rotateGrid(int[][] grid, int k) {
            this.ROWS = grid.length;
            this.COLS = grid[0].length;

            int limit = Math.min(ROWS, COLS) / 2;

            for(int diagonal = 0; diagonal < limit; diagonal++) {
                List<Integer> array = arrayMaker(grid, diagonal);
                array = rotator(array, k);
                plotter(array, grid, diagonal);
            }

            return grid;
        }

        private List<Integer> arrayMaker(int[][] grid, int diagonal) {
            List<Integer> list = new ArrayList<>();

            int start_X = diagonal,  start_Y = diagonal;
            int limit_X = ROWS - diagonal - 1,  limit_Y = COLS - diagonal - 1;

            for(; start_Y <=  limit_Y; start_Y++) list.add(grid[start_X][start_Y]);
            start_Y--;
            start_X++;

            for(; start_X <= limit_X; start_X++) list.add(grid[start_X][start_Y]);
            start_X--;
            start_Y--;

            for (; start_Y >= diagonal; start_Y--) list.add(grid[start_X][start_Y]);
            start_Y++;
            start_X--;

            for(; start_X > diagonal; start_X--) list.add(grid[start_X][start_Y]);

            return list;
        }

        private List<Integer> rotator(List<Integer> list, int k){
            final int N = list.size();
            k = k % N;

            List<Integer> newList = new ArrayList<>();
            for(int i = 0; i < N; i++ ){
                int newI = (i + k) % N;
                newList.add(list.get(newI));
            }
            return newList;
        }

        private void plotter(List<Integer> list, int[][] grid, int diagonal){

            int start_X = diagonal,  start_Y = diagonal;
            int limit_X = ROWS - diagonal - 1,  limit_Y = COLS - diagonal - 1;
            int k = 0;

            for(; start_Y <=  limit_Y; start_Y++) grid[start_X][start_Y] = list.get(k++);
            start_Y--;
            start_X++;

            for(; start_X <= limit_X; start_X++) grid[start_X][start_Y] = list.get(k++);
            start_X--;
            start_Y--;

            for (; start_Y >= diagonal; start_Y--) grid[start_X][start_Y] = list.get(k++);
            start_Y++;
            start_X--;

            for(; start_X > diagonal; start_X--) grid[start_X][start_Y] = list.get(k++);
        }

    }

}
